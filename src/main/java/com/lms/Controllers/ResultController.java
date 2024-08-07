package com.lms.Controllers;

import com.lms.DTOs.ResultDTO;
import com.lms.Services.Service.ResultService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/result")
public class ResultController {

    private final ResultService resultService;

    @Autowired
    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }


    @GetMapping("{studentId}/{courseId}/getById")
    public ResponseEntity<ResultDTO> findResultById(@PathVariable String studentId, @PathVariable String courseId) {
        return ResponseEntity.ok(resultService.getResultById(studentId, courseId));
    }

    @PreAuthorize("hasRole('ROLE_FACULTY')")
    @PostMapping("{studentId}/{courseId}/add")
    public ResponseEntity<ResultDTO> addResult(@Valid @RequestBody ResultDTO result,@PathVariable String studentId,@PathVariable String courseId) {
        return ResponseEntity.ok(resultService.saveResult(result, studentId, courseId));
    }

    @PreAuthorize("hasRole('ROLE_FACULTY')")
    @PutMapping("{studentId}/{courseId}/update")
    public ResponseEntity<ResultDTO> updateResult(@Valid @RequestBody ResultDTO result,@PathVariable String studentId,@PathVariable String courseId) {
        return ResponseEntity.ok(resultService.updateResult(result, studentId, courseId));
    }

    @PreAuthorize("hasRole('ROLE_FACULTY')")
    @DeleteMapping("{studentId}/{courseId}/delete")
    public ResponseEntity<?> deleteResult(@PathVariable String studentId,@PathVariable String courseId) {
        resultService.deleteResult(studentId, courseId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{studentId}/getByStudentId")
    public ResponseEntity<List<ResultDTO>> findResultByStudentId(@PathVariable String studentId, Authentication authentication) {
        return ResponseEntity.ok(resultService.getResultByStudentId(studentId, authentication));
    }

    @PreAuthorize("hasRole('ROLE_FACULTY')")
    @GetMapping("{courseId}/getByCourseId")
    public ResponseEntity<List<ResultDTO>> findResultByCourseId(@PathVariable String courseId) {
        return ResponseEntity.ok(resultService.getResultByCourseId(courseId));
    }
}
