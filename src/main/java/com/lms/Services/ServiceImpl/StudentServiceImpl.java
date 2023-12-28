package com.lms.Services.ServiceImpl;

import com.lms.DTOs.CourseDTO;
import com.lms.DTOs.StudentDTO;
import com.lms.Entities.Branch;
import com.lms.Entities.Student;
import com.lms.Exception.BadCredentialsException;
import com.lms.Exception.ResourceNotFoundException;
import com.lms.Helper.ModelMappers;
import com.lms.Repositories.BranchRepository;
import com.lms.Repositories.CourseRepository;
import com.lms.Repositories.StudentRepository;
import com.lms.Services.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final BranchRepository branchRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, BranchRepository branchRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.branchRepository = branchRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public StudentDTO addStudent(StudentDTO student) {
        student.setId(UUID.randomUUID().toString());
        return ModelMappers.StudentToStudentDTO(this.studentRepository.save(ModelMappers.StudentDToToStudent(student)));
    }

    @Override
    public void deleteStudent(String id) {
        this.studentRepository.delete(this.studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student Not Found")));
    }

    @Override
    public StudentDTO updateStudent(String id, StudentDTO student) {
        student.setId(id);
        return ModelMappers.StudentToStudentDTO(
                this.studentRepository.save(
                        ModelMappers.StudentDToToStudent(
                                this.studentRepository.findById(id)
                                        .orElseThrow(()-> new ResourceNotFoundException("Student Not Found")), student)));
    }

    @Override
    public StudentDTO getStudent(String id) {
        return ModelMappers.StudentToStudentDTO(this.studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student Not Found")));
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return this.studentRepository.findAll().stream().map(student -> ModelMappers.StudentToStudentDTO(student)).collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> getStudentByBranch(Branch branch) {
        return Optional.ofNullable(this.studentRepository.findByBranch(this.branchRepository.findById(branch.getBranch_id())
                .orElseThrow(()-> new ResourceNotFoundException("Branch Not Found"))))
                .orElse(Collections.emptyList())
                .stream().map(student -> ModelMappers.StudentToStudentDTO(student))
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> getStudentByName(String name) {
        return Optional.ofNullable(this.studentRepository.findByName(name))
                .orElse(Collections.emptyList())
                .stream().map(student -> ModelMappers.StudentToStudentDTO(student))
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> getStudentByCourse(CourseDTO courseDTO) {
        return Optional.ofNullable(this.studentRepository.findByCourseListIsContaining(ModelMappers.CourseDTOTOCourse(courseDTO)))
                .orElse(Collections.emptyList())
                .stream().map(student -> ModelMappers.StudentToStudentDTO(student))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO addCourseToStudent(String studentId, List<CourseDTO> courses) throws BadCredentialsException {
        if (courses.isEmpty()){
            throw new BadCredentialsException("Course List is Empty");
        }
        Student temp = this.studentRepository.findById(studentId)
                .orElseThrow(()-> new ResourceNotFoundException("Student Not Found"));
        temp.setCourseList(courses.stream()
                .map(courseDTO -> ModelMappers.CourseDTOTOCourse(courseDTO))
                .collect(Collectors.toList()));
        return ModelMappers.StudentToStudentDTO(this.studentRepository.save(temp));
    }

    @Override
    public StudentDTO removeCourseFromStudent(String studentId, CourseDTO courseDTO){

        Student temp = this.studentRepository.findById(studentId)
                .orElseThrow(()-> new ResourceNotFoundException("Student Not Found"));
        if (!temp.getCourseList().isEmpty()) {
            temp.setCourseList(temp.getCourseList().stream()
                    .filter(course -> !course.getCourse_id().equals(courseDTO.getCourse_id()))
                    .collect(Collectors.toList()));
        }
        return ModelMappers.StudentToStudentDTO(this.studentRepository.save(temp));
    }
}
