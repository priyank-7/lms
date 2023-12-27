package com.lms.Controllers;

import com.lms.DTOs.CourseDTO;
import com.lms.DTOs.StudentDTO;
import com.lms.Entities.Branch;
import com.lms.Exception.BadCredentialsException;
import com.lms.Services.Service.StudentService;
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
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO){
        return ResponseEntity.ok(this.studentService.addStudent(studentDTO));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable String id){
        return ResponseEntity.ok(this.studentService.getStudent(id));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable String id, @RequestBody StudentDTO studentDTO){
        return ResponseEntity.ok(this.studentService.updateStudent(id, studentDTO));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteStudent(@PathVariable String id){
        this.studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getall")
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
        return ResponseEntity.ok(this.studentService.getAllStudents());
    }

    @GetMapping("/getbyname/{name}")
    public ResponseEntity<List<StudentDTO>> getStudentByName(@PathVariable String name){
        return ResponseEntity.ok(this.studentService.getStudentByName(name));
    }

    @GetMapping("/getbybranch")
    public ResponseEntity<List<StudentDTO>> getStudentByBranch(@RequestBody Branch branch){
        return ResponseEntity.ok(this.studentService.getStudentByBranch(branch));
    }

    @GetMapping("/getbycourse")
    public ResponseEntity<List<StudentDTO>> getStudentByCourse(@RequestBody CourseDTO course){
        return ResponseEntity.ok(this.studentService.getStudentByCourse(course));
    }

    @PostMapping("/{studentId}/addcourse")
    public ResponseEntity<StudentDTO> addCourseToStudent(@PathVariable String studentId, @RequestBody List<CourseDTO> courses) throws BadCredentialsException {
        return ResponseEntity.ok(this.studentService.addCourseToStudent(studentId, courses));
    }

}
