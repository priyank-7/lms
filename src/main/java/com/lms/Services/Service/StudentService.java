package com.lms.Services.Service;

import com.lms.DTOs.CourseDTO;
import com.lms.DTOs.StudentDTO;
import com.lms.Entities.Branch;
import com.lms.Exception.BadCredentialsException;


import java.util.List;

public interface StudentService {

    StudentDTO addStudent(StudentDTO student);

    void deleteStudent(String id);

    StudentDTO updateStudent(String id, StudentDTO student);

    StudentDTO getStudent(String id);

    List<StudentDTO> getAllStudents();

    List<StudentDTO> getStudentByBranch(Branch branch);

    List<StudentDTO> getStudentByName(String name);

    List<StudentDTO> getStudentByCourse(CourseDTO courseDTO);

    StudentDTO addCourseToStudent(String studentId, List<CourseDTO> courses) throws BadCredentialsException;
}
