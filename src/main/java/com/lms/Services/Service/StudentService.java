package com.lms.Services.Service;

import com.lms.DTOs.StudentDTO;
import com.lms.Entities.Student;

import java.util.List;

public interface StudentService {

    void addStudent(Student student);

    void deleteStudent(String id);

    void updateStudent(String id, Student student);

    StudentDTO getStudent(String id);

    List<StudentDTO> getAllStudents();

    StudentDTO getStudentByBranch(String branchId);

    StudentDTO getStudentByName(String name);
}
