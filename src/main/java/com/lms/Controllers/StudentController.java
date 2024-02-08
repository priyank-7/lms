package com.lms.Controllers;

import com.lms.DTOs.CourseDTO;
import com.lms.DTOs.StudentDTO;
import com.lms.Entities.Student;
import com.lms.Entities.Student_Course;
import com.lms.Services.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/add")
    public ResponseEntity<StudentDTO> addStudent(@Valid @RequestBody StudentDTO studentDTO){
        return ResponseEntity.ok(this.studentService.addStudent(studentDTO));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
        return ResponseEntity.ok(this.studentService.getAllStudents());
    }

    @GetMapping("/get/{student_id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable String student_id){
        return ResponseEntity.ok(this.studentService.getStudentById(student_id));
    }

    @DeleteMapping("/{student_id}/delete")
    public ResponseEntity<Void> deleteStudent(@PathVariable String student_id, @RequestBody StudentDTO studentDTO){
        this.studentService.deleteStudent(student_id, studentDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{student_id}/addcourse")
    public ResponseEntity<StudentDTO> addCourseToStudent(@PathVariable String student_id, @RequestBody CourseDTO courseDTO){
        return ResponseEntity.ok(this.studentService.addCourseToStudent(student_id, courseDTO));
    }
}
