package com.lms.Services.ServiceImpl;

import com.github.f4b6a3.ulid.UlidCreator;
import com.lms.DTOs.QuizDTO;
import com.lms.Entities.Course;
import com.lms.Entities.Quiz;
import com.lms.Entities.User;
import com.lms.Exception.ResourceNotFoundException;
import com.lms.Helper.DateTime.DateTimeUtilities;
import com.lms.Helper.ModelMappers.CourseMapper;
import com.lms.Helper.ModelMappers.QuizMapper;
import com.lms.Repositories.CourseRepository;
import com.lms.Repositories.FacultyRepository;
import com.lms.Repositories.QuizRepository;
import com.lms.Repositories.StudentCourseRepository;
import com.lms.Services.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final CourseRepository courseRepository;
    private final FacultyRepository facultyRepository;

    private final StudentCourseRepository studentCourseRepository;

    @Autowired
    public QuizServiceImpl(QuizRepository quizRepository, CourseRepository courseRepository, FacultyRepository facultyRepository, StudentCourseRepository studentCourseRepository) {
        this.quizRepository = quizRepository;
        this.courseRepository = courseRepository;
        this.facultyRepository = facultyRepository;
        this.studentCourseRepository = studentCourseRepository;
    }

    @Override
    public QuizDTO getQuizById(String id, Authentication connectedUser) {

        var tempQuiz = this.quizRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Quiz not found"));

        User user = (User)connectedUser.getPrincipal();
        user.getRoles().forEach(role -> {
            if(role.getName().equals("ROLE_FACULTY")){
                if(!checkIfFacultyIsAssignedToCourse(user.getUser_id(), tempQuiz.getCourse().getCourse_id())){
                    throw new ResourceNotFoundException("User not assigned to course");
                }
            }
            else if(role.getName().equals("ROLE_STUDENT") || role.getName().equals("ROLE_TEACHING_ASSISTANT")){
                if(!checkIfStudentIsAnrolledToCourse(user.getUser_id(), tempQuiz.getCourse().getCourse_id())){
                    throw new ResourceNotFoundException("User not assigned to course");
                }
            }
            else throw new ResourceNotFoundException("User not assigned to course");
        });

        if(!checkIfFacultyIsAssignedToCourse(user.getUser_id(), tempQuiz.getCourse().getCourse_id())){
            throw new ResourceNotFoundException("User not assigned to course");
        }
        return QuizMapper.QuizToQuizDTO(tempQuiz);
    }

    @Override
    public QuizDTO addQuiz(QuizDTO quizDTO, String courseId, Authentication connectedUser) {
        User user = (User)connectedUser.getPrincipal();
        if(!checkIfFacultyIsAssignedToCourse(user.getUser_id(), courseId)){
            throw new ResourceNotFoundException("User not assigned to course");
        }
        quizDTO.setCourse(
                CourseMapper.CourseToCourseDTO(this.courseRepository.findById(courseId)
                .orElseThrow(()-> new ResourceNotFoundException("Course not found"))));
        quizDTO.setQuiz_id(UlidCreator.getUlid().toString());
        quizDTO.setPosted_on(new Date());
        quizDTO.setIs_active(false);
        return QuizMapper.QuizToQuizDTO(this.quizRepository.save(QuizMapper.QuizDTOToQuiz(quizDTO)));
    }

    @Override
    public QuizDTO updateQuiz(String id, QuizDTO quizDTO, Authentication connectedUser) {
        User user = (User)connectedUser.getPrincipal();
        if(!checkIfFacultyIsAssignedToCourse(user.getUser_id(), quizDTO.getCourse().getCourse_id())){
            throw new ResourceNotFoundException("User not assigned to course");
        }
        Quiz quiz = this.quizRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Quiz not found"));
        return QuizMapper.QuizToQuizDTO(this.quizRepository.save(QuizMapper.QuizDTOToQuiz(quizDTO, quiz)));
    }

    @Override
    public void deleteQuiz(String id, Authentication connectedUser) {
        Quiz tempQuiz = this.quizRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Quiz not found"));
        User user = (User)connectedUser.getPrincipal();
        if(!checkIfFacultyIsAssignedToCourse(user.getUser_id(), tempQuiz.getCourse().getCourse_id())){
            throw new ResourceNotFoundException("User not assigned to course");
        }
        this.quizRepository.delete(tempQuiz);
    }

    @Override
    public List<QuizDTO> getQuizByCourse(String courseId, Authentication connectedUser) {

        Course tempCourse = this.courseRepository.findById(courseId)
                .orElseThrow(()-> new ResourceNotFoundException("Course not found"));

        User user = (User)connectedUser.getPrincipal();
        user.getRoles().forEach(role -> {
            if(role.getName().equals("ROLE_FACULTY")){
                if(!checkIfFacultyIsAssignedToCourse(user.getUser_id(), tempCourse.getCourse_id())){
                    throw new ResourceNotFoundException("User not assigned to course");
                }
            }
            else if(role.getName().equals("ROLE_STUDENT") || role.getName().equals("ROLE_TEACHING_ASSISTANT")){
                if(!checkIfStudentIsAnrolledToCourse(user.getUser_id(), tempCourse.getCourse_id())){
                    throw new ResourceNotFoundException("User not assigned to course");
                }
            }
            else throw new ResourceNotFoundException("User not assigned to course");
        });

        return Optional.of(this.quizRepository.findAllByPostedOnAfterAndCourse(DateTimeUtilities.firstDayOfYear(), tempCourse))
                .orElse(Collections.emptyList())
                .stream().map(QuizMapper::QuizToQuizDTO)
                .collect(Collectors.toList());
    }
    private boolean checkIfFacultyIsAssignedToCourse(String faculty_id, String courseId){
        return this.facultyRepository.findFacultyByCourseListExists(faculty_id, courseId) > 0;
    }

    private boolean checkIfStudentIsAnrolledToCourse(String student_id, String courseId){
        return this.studentCourseRepository.findStudentByCourseListExists(student_id, courseId) > 0;
    }
}
