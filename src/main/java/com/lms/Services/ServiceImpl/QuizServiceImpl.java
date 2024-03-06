package com.lms.Services.ServiceImpl;

import com.github.f4b6a3.ulid.UlidCreator;
import com.lms.DTOs.CourseDTO;
import com.lms.DTOs.QuizDTO;
import com.lms.Entities.Course;
import com.lms.Entities.Quiz;
import com.lms.Exception.ResourceNotFoundException;
import com.lms.Helper.DateTime.DateTimeUtilities;
import com.lms.Helper.ModelMappers.CourseMapper;
import com.lms.Helper.ModelMappers.QuizMapper;
import com.lms.Repositories.CourseRepository;
import com.lms.Repositories.QuizRepository;
import com.lms.Services.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public QuizServiceImpl(QuizRepository quizRepository, CourseRepository courseRepository) {
        this.quizRepository = quizRepository;
        this.courseRepository = courseRepository;
    }


    @Override
    public List<QuizDTO> getAllQuizzes() {
        return Optional.of(this.quizRepository.findAll())
                .orElse(Collections.emptyList())
                .stream().map(QuizMapper::QuizToQuizDTO)
                .collect(Collectors.toList());
    }

    @Override
    public QuizDTO getQuizById(String id) {
        return QuizMapper.QuizToQuizDTO(this.quizRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Quiz not found")));
    }

    @Override
    public QuizDTO addQuiz(QuizDTO quizDTO, String courseId) {
        quizDTO.setCourse(
                CourseMapper.CourseToCourseDTO(this.courseRepository.findById(courseId)
                .orElseThrow(()-> new ResourceNotFoundException("Course not found"))));
        quizDTO.setQuiz_id(UlidCreator.getUlid().toString());
        quizDTO.setPosted_on(new Date());
        quizDTO.setIs_active(false);
        return QuizMapper.QuizToQuizDTO(this.quizRepository.save(QuizMapper.QuizDTOToQuiz(quizDTO)));
    }

    @Override
    public QuizDTO updateQuiz(String id, QuizDTO quizDTO) {
        Quiz quiz = this.quizRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Quiz not found"));
        return QuizMapper.QuizToQuizDTO(this.quizRepository.save(QuizMapper.QuizDTOToQuiz(quizDTO, quiz)));
    }

    @Override
    public void deleteQuiz(String id) {
        this.quizRepository.delete(this.quizRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Quiz not found")));
    }

    @Override
    public List<QuizDTO> getQuizByCourse(CourseDTO course) {
        Course tempCourse = this.courseRepository.findById(course.getCourse_id())
                        .orElseThrow(()-> new ResourceNotFoundException("Course not found"));
        System.out.println(DateTimeUtilities.firstDayOfYear());
        return Optional.of(this.quizRepository.findAllByPostedOnAfterAndCourse(DateTimeUtilities.firstDayOfYear(), tempCourse))
                .orElse(Collections.emptyList())
                .stream().map(QuizMapper::QuizToQuizDTO)
                .collect(Collectors.toList());
    }
}
