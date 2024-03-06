package com.lms.Services.ServiceImpl;

import com.github.f4b6a3.ulid.UlidCreator;
import com.lms.DTOs.CourseDTO;
import com.lms.DTOs.StudentDTO;
import com.lms.Entities.Course;
import com.lms.Entities.Student;
import com.lms.Entities.User;
import com.lms.Exception.ResourceNotFoundException;
import com.lms.Helper.ModelMappers.StudentMapper;
import com.lms.Helper.Roles;
import com.lms.Repositories.*;
import com.lms.Services.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository, UserRepository userRepository, RoleRepository roleRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public StudentDTO addStudent(StudentDTO studentDTO){
        String Id = UlidCreator.getUlid().toString();
        studentDTO.setStudent_id(Id);
        User tempUser = User.builder().user_id(Id).email(studentDTO.getEmail()).password(studentDTO.getPhone()).build();
        Optional.ofNullable(tempUser.getRoles())
                .orElse(new HashSet<>())
                .add(this.roleRepository.findByName(Roles.ROLE_STUDENT.toString()));
        this.userRepository.save(tempUser);
        return StudentMapper.StudentToStudentDTO(this.studentRepository.save(StudentMapper.StudentDTOToStudent(studentDTO)));
    }

    @Override
    public StudentDTO updateStudent(String student_id, StudentDTO studentDTO) {
        Student tempStudent = this.studentRepository.findById(student_id)
                .orElseThrow(()-> new ResourceNotFoundException("Student not found"));
        studentDTO.setStudent_id(student_id);
        return StudentMapper.StudentToStudentDTO(this.studentRepository.save(StudentMapper.StudentDTOToStudent(tempStudent, studentDTO)));
    }

    @Override
    public StudentDTO getStudentById(String student_id) {
        return StudentMapper.StudentToStudentDTO(studentRepository.findById(student_id)
                .orElseThrow(()-> new ResourceNotFoundException("Student not found")));
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return Optional.of(studentRepository.findAll())
                .orElse(Collections.emptyList())
                .stream()
                .map(StudentMapper::StudentToStudentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteStudent(String student_id, StudentDTO studentDTO) {
        this.studentRepository.delete(this.studentRepository.findById(student_id)
                .orElseThrow(()-> new ResourceNotFoundException("Student not found")));
    }

    @Override
    public StudentDTO addCourseToStudent(String student_id, CourseDTO courseDTO) {
        Student tempStudent = this.studentRepository.findById(student_id)
                .orElseThrow(()-> new ResourceNotFoundException("Student not found"));
        Course tempCourse = this.courseRepository.findById(courseDTO.getCourse_id())
                .orElseThrow(()-> new ResourceNotFoundException("Course not found"));
        tempStudent.setStudentCourses(Optional.ofNullable(tempStudent.getStudentCourses())
                .orElse(new ArrayList<>()));
        tempStudent.getStudentCourses().add(StudentMapper.Student_Course_Creation(tempStudent, tempCourse));
        return StudentMapper.StudentToStudentDTO(this.studentRepository.save(tempStudent));
    }

    @Override
    public StudentDTO removeCourseFromStudent(String student_id, CourseDTO courseDTO) {
        Student tempStudent = this.studentRepository.findById(student_id)
                .orElseThrow(()-> new ResourceNotFoundException("Student not found"));
        tempStudent.setStudentCourses(Optional.ofNullable(tempStudent.getStudentCourses())
                .orElse(Collections.emptyList())
                .stream()
                .filter(course -> !course.getStudent_course_pk().getCourse().getCourse_id().equals(courseDTO.getCourse_id()))
                .collect(Collectors.toList()));
        return StudentMapper.StudentToStudentDTO(this.studentRepository.save(tempStudent));
    }

}
