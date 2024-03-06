package com.lms.Controllers;

import com.lms.DTOs.CourseDTO;
import com.lms.Services.Service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/add")
    public ResponseEntity<CourseDTO> addCourse(@Valid @RequestBody CourseDTO courseDTO) {
        return ResponseEntity.ok(this.courseService.addCourse(courseDTO));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteCourse(@PathVariable String id) {
        this.courseService.deleteCourse(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{course_id}/update")
    public ResponseEntity<CourseDTO> updateCourse(@PathVariable String course_id ,@Valid @RequestBody CourseDTO courseDTO) {
        return ResponseEntity.ok(this.courseService.updateCourse(course_id, courseDTO));
    }

    @GetMapping("/get/{course_id}")
    public ResponseEntity<CourseDTO> getCourse(@PathVariable String course_id) {
        return ResponseEntity.ok(this.courseService.getCourse(course_id));
    }

    @GetMapping("/getByName/{course_name}")
    public ResponseEntity<CourseDTO> getCourseByName(@PathVariable String course_name) {
        return ResponseEntity.ok(this.courseService.getCourseByName(course_name));
    }

    @GetMapping("/getByCredits/{course_credits}")
    public ResponseEntity<List<CourseDTO>> getCourseByCredits(@PathVariable String course_credits) {
        return ResponseEntity.ok(this.courseService.getCourseByCreditsEquals(Float.valueOf(course_credits)));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        return ResponseEntity.ok(this.courseService.getAllCourses());
    }
}
