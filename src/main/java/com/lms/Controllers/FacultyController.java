package com.lms.Controllers;

import com.lms.DTOs.CourseDTO;
import com.lms.DTOs.FacultyDTO;
import com.lms.Entities.Branch;
import com.lms.Exception.BadCredentialsException;
import com.lms.Services.Service.FacultyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculties")
public class FacultyController {

    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<FacultyDTO> getFaculty(@PathVariable String id){
        return ResponseEntity.ok(this.facultyService.getFaculty(id));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<FacultyDTO>> getAllFaculties(){
        return ResponseEntity.ok(this.facultyService.getAllFaculties());
    }

    @PostMapping("/add")
    public ResponseEntity<FacultyDTO> addFaculty(@Valid @RequestBody FacultyDTO facultyDTO){
        return ResponseEntity.ok(this.facultyService.addFaculty(facultyDTO));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<FacultyDTO> updateFaculty(@PathVariable String id, @Valid @RequestBody FacultyDTO facultyDTO){
        return ResponseEntity.ok(this.facultyService.updateFaculty(id, facultyDTO));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteFaculty(@PathVariable String id){
        this.facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{faculty_id}/addcourse")
    public ResponseEntity<FacultyDTO> addCourseToFaculty(@PathVariable String faculty_id, @Valid @RequestBody List<CourseDTO> courses) throws BadCredentialsException {
        return ResponseEntity.ok(this.facultyService.addCourseToFaculty(faculty_id, courses));
    }

    @GetMapping("/getbyname/{name}")
    public ResponseEntity<List<FacultyDTO>> getFacultyByName(@PathVariable String name){
        return ResponseEntity.ok(this.facultyService.getFacultyByName(name));
    }

    @PutMapping("/{faculty_id}/removecourse")
    public ResponseEntity<FacultyDTO> removeCourseFromFaculty(@PathVariable String faculty_id, @Valid @RequestBody CourseDTO courseDTO){
        return ResponseEntity.ok(this.facultyService.removeCourseFromFaculty(faculty_id, courseDTO));
    }
}
