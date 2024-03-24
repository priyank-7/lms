package com.lms.Controllers;

import com.lms.DTOs.AssignmentDTO;
import com.lms.DTOs.CourseDTO;
import com.lms.Services.Service.AssignmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {

    private final AssignmentService assignmentService;

    @Autowired
    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }


    @PreAuthorize("hasRole('ROLE_FACULTY')")
    @PostMapping("/add")
    public ResponseEntity<AssignmentDTO> addAssignment(@Valid @RequestBody AssignmentDTO assignmentDTO){
        return ResponseEntity.ok(this.assignmentService.addAssignment(assignmentDTO));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AssignmentDTO> getAssignmentById(@PathVariable String id){
        return ResponseEntity.ok(this.assignmentService.getAssignmentById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AssignmentDTO>> getAllAssignments(){
        return ResponseEntity.ok(this.assignmentService.getAllAssignments());
    }

    @PreAuthorize("hasRole('ROLE_FACULTY')")
    @PutMapping("/{id}/update")
    public ResponseEntity<AssignmentDTO> updateAssignment(@PathVariable String id, @Valid @RequestBody AssignmentDTO assignmentDTO){
        return ResponseEntity.ok(this.assignmentService.updateAssignment(id, assignmentDTO));
    }

    @PreAuthorize("hasRole('ROLE_FACULTY')")
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteAssignment(@PathVariable String id){
        this.assignmentService.deleteAssignment(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getByCourse")
    public ResponseEntity<List<AssignmentDTO>> getAssignmentsByCourse(@Valid @RequestBody CourseDTO Course){
        return ResponseEntity.ok(this.assignmentService.getAssignmentsByCourse(Course));
    }

}
