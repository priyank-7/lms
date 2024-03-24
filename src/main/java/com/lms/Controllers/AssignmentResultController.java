package com.lms.Controllers;

import com.lms.DTOs.AssignmentResultDTO;
import com.lms.Services.Service.AssignmentResultService;
import com.lms.Services.ServiceImpl.AssignmentResultServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignment_result")
public class AssignmentResultController {

    private final AssignmentResultService assignmentResultService;

    @Autowired
    public AssignmentResultController(AssignmentResultServiceImpl assignmentResultService) {
        this.assignmentResultService = assignmentResultService;
    }

    @PreAuthorize("hasRole('ROLE_FACULTY')")
    @PostMapping("/{student_id}/{assignment_id}/add")
    public ResponseEntity<AssignmentResultDTO> addAssignmentResult(@PathVariable("student_id")String student_id,@PathVariable("assignment_id")String assignment_id, @Valid @RequestBody AssignmentResultDTO assignmentResultDTO) {
        return ResponseEntity.ok(this.assignmentResultService.addAssignmentResult(assignmentResultDTO, student_id, assignment_id));
    }

    @GetMapping("{assignmentResult_id}/get")
    public ResponseEntity<AssignmentResultDTO> getAssignmentResult(@PathVariable("assignmentResult_id") String assignmentResult_id) {
        return ResponseEntity.ok(this.assignmentResultService.getAssignmentResult(assignmentResult_id));
    }

    @GetMapping("/{student_id}/getByStudent")
    public ResponseEntity<List<AssignmentResultDTO>> getAssignmentResultByStudent(@PathVariable("student_id") String student_id) {
        return ResponseEntity.ok(this.assignmentResultService.getAssignmentResultByStudent(student_id));
    }

    @PreAuthorize("hasRole('ROLE_FACULTY')")
    @PutMapping("/{assignment_id}/update")
    public ResponseEntity<AssignmentResultDTO> updateAssignmentResult(@Valid @RequestBody AssignmentResultDTO assignmentResultDTO, @PathVariable("assignment_id") String assignment_id) {
        return ResponseEntity.ok(this.assignmentResultService.updateAssignmentResult(assignmentResultDTO, assignment_id));
    }

    @PreAuthorize("hasRole('ROLE_FACULTY')")
    @DeleteMapping("/{assignmentResult_id}/delete")
    public ResponseEntity<?> deleteAssignmentResult(@PathVariable String assignmentResult_id) {
        this.assignmentResultService.deleteAssignmentResult(assignmentResult_id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{student_id}/{assignment_id}/get")
    public ResponseEntity<AssignmentResultDTO> getAssignmentResultByStudentAndAssignment(@PathVariable("student_id")String student_id, @PathVariable("assignment_id") String assignment_id) {
        return ResponseEntity.ok(this.assignmentResultService.getAssignmentResultByAssignmentAndStudent(student_id, assignment_id));
    }

    @GetMapping("/{assignment_id}/getByAssignment")
    public ResponseEntity<List<AssignmentResultDTO>> getAssignmentResultByAssignment(@PathVariable("assignment_id") String assignment_id) {
        return ResponseEntity.ok(this.assignmentResultService.getAssignmentResultByAssignment(assignment_id));
    }


}
