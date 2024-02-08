package com.lms.Services.Service;

import com.lms.DTOs.CourseDTO;
import com.lms.DTOs.StudentDTO;
import com.lms.Entities.Student;
import com.lms.Entities.Student_Course;
import com.lms.Entities.User;

import java.util.List;

public interface StudentService {

    StudentDTO addStudent(StudentDTO studentDTO);

    StudentDTO updateStudent(String student_id, StudentDTO studentDTO);

    StudentDTO getStudentById(String id);

    List<StudentDTO> getAllStudents();

    void deleteStudent(String id, StudentDTO studentDTO);

    StudentDTO addCourseToStudent(String student_id, CourseDTO courseDTO);

    StudentDTO removeCourseFromStudent(String student_id, CourseDTO courseDTO);

}
