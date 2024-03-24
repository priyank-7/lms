package com.lms.Controllers;

import com.lms.DTOs.CourseDTO;
import com.lms.DTOs.StudentDTO;
import com.lms.Entities.Student;
import com.lms.Entities.Student_Course;
import com.lms.Services.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

   @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<StudentDTO> addStudent(@Valid @RequestBody StudentDTO studentDTO){
        return ResponseEntity.ok(this.studentService.addStudent(studentDTO));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/getall")
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
        return ResponseEntity.ok(this.studentService.getAllStudents());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/get/{student_id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable String student_id){
        return ResponseEntity.ok(this.studentService.getStudentById(student_id));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{student_id}/delete")
    public ResponseEntity<Void> deleteStudent(@PathVariable String student_id, @RequestBody StudentDTO studentDTO){
        this.studentService.deleteStudent(student_id, studentDTO);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/{student_id}/addcourse")
    public ResponseEntity<StudentDTO> addStudentToCourse(@PathVariable String student_id, @RequestBody CourseDTO courseDTO){
        return ResponseEntity.ok(this.studentService.addCourseToStudent(student_id, courseDTO));
    }
}
