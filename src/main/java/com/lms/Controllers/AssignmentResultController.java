package com.lms.Controllers;

import com.lms.DTOs.AssignmentResultDTO;
import com.lms.Services.Service.AssignmentResultService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignment_result")
public class AssignmentResultController {

    private final AssignmentResultService assignmentResultService;

    @Autowired
    public AssignmentResultController(AssignmentResultService assignmentResultService) {
        this.assignmentResultService = assignmentResultService;
    }

    @PostMapping("/{student_id}/{assignment_id}/add")
    public ResponseEntity<AssignmentResultDTO> addAssignmentResult(@PathVariable("student_id")String student_id,@PathVariable("assignment_id")String assignment_id, @Valid AssignmentResultDTO assignmentResultDTO) {
        return ResponseEntity.ok(this.assignmentResultService.addAssignmentResult(assignmentResultDTO, student_id));
    }

    @GetMapping("/{student_id}/get")
    public ResponseEntity<List<AssignmentResultDTO>> getAssignmentResultByStudent(@PathVariable("student_id") String student_id) {
        return ResponseEntity.ok(this.assignmentResultService.getAssignmentResultByStudent(student_id));
    }

    @PutMapping("/{assignment_id}/update")
    public ResponseEntity<AssignmentResultDTO> updateAssignmentResult(@Valid AssignmentResultDTO assignmentResultDTO, @PathVariable String assignment_id) {
        return ResponseEntity.ok(this.assignmentResultService.updateAssignmentResult(assignmentResultDTO, assignment_id));
    }

    @DeleteMapping("/{assignmentResult_id}/delete")
    public ResponseEntity<?> deleteAssignmentResult(@PathVariable String assignmentResult_id) {
        this.assignmentResultService.deleteAssignmentResult(assignmentResult_id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{student_id}/{assignment_id}/get")
    public ResponseEntity<AssignmentResultDTO> getAssignmentResultByStudentAndAssignment(@PathVariable("student_id")String student_id, @PathVariable("assignment_id") String assignment_id) {
        return ResponseEntity.ok(this.assignmentResultService.getAssignmentResultByAssignmentAndStudent(student_id, assignment_id));
    }


}
