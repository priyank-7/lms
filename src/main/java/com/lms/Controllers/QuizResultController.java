package com.lms.Controllers;

import com.lms.DTOs.QuizResultDTO;
import com.lms.Services.Service.QuizResultService;
import com.lms.Services.ServiceImpl.QuizResultServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizResult")
public class QuizResultController {

    private final QuizResultService quizResultService;

    @Autowired
    public QuizResultController(QuizResultServiceImpl quizResultService) {
        this.quizResultService = quizResultService;
    }

    @PreAuthorize("hasRole('ROLE_FACULTY')")
    @PostMapping("/{student_id}/{quiz_id}/add")
    public ResponseEntity<QuizResultDTO> addQuizResult(
            @PathVariable("student_id")String student_id,
            @PathVariable("quiz_id")String quiz_id,
            @Valid @RequestBody QuizResultDTO quizResultDTO,
            Authentication connectedUser){
        return ResponseEntity.ok(this.quizResultService.addQuizResult(quizResultDTO, student_id, quiz_id, connectedUser));
    }

    @GetMapping("{quizResult_id}/get")
    public ResponseEntity<QuizResultDTO> getQuizResult(
            @PathVariable("quizResult_id") String quizResult_id,
            Authentication connectedUser) {
        return ResponseEntity.ok(this.quizResultService.getQuizResult(quizResult_id, connectedUser));
    }

    @GetMapping("/{student_id}/getByStudent")
    public ResponseEntity<List<QuizResultDTO>> getQuizResultByStudent(
            @PathVariable("student_id") String student_id,
            Authentication connectedUser) {
        return ResponseEntity.ok(this.quizResultService.getQuizResultByStudent(student_id, connectedUser));
    }

    @PreAuthorize("hasRole('ROLE_FACULTY')")
    @PutMapping("/{quizResult_id}/update")
    public ResponseEntity<QuizResultDTO> updateQuizResult(
            @Valid @RequestBody QuizResultDTO quizResultDTO,
            @PathVariable("quizResult_id") String quizResult_id,
            Authentication connectedUser) {
        return ResponseEntity.ok(this.quizResultService.updateQuizResult(quizResultDTO, quizResult_id, connectedUser));
    }

    @PreAuthorize("hasRole('ROLE_FACULTY')")
    @DeleteMapping("/{quizResult_id}/delete")
    public ResponseEntity<?> deleteQuizResult(
            @PathVariable String quizResult_id,
            Authentication connectedUser) {
        this.quizResultService.deleteQuizResult(quizResult_id, connectedUser);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{student_id}/{quiz_id}/get")
    public ResponseEntity<QuizResultDTO> getQuizResultByStudentAndQuiz(
            @PathVariable("student_id")String student_id,
            @PathVariable("quiz_id") String quiz_id,
            Authentication connectedUser) {
        return ResponseEntity.ok(this.quizResultService.getQuizResultByQuizAndStudent(student_id, quiz_id, connectedUser));
    }

    @GetMapping("/{quiz_id}/getByQuiz")
    public ResponseEntity<List<QuizResultDTO>> getQuizResultByQuiz(
            @PathVariable("quiz_id") String quiz_id,
            Authentication connectedUser) {
        return ResponseEntity.ok(this.quizResultService.getQuizResultByQuiz(quiz_id, connectedUser));
    }
}
