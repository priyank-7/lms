package com.lms.Controllers;

import com.lms.DTOs.CourseDTO;
import com.lms.DTOs.QuizDTO;
import com.lms.Services.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<QuizDTO> getQuizById(@PathVariable String id){
        return ResponseEntity.ok(this.quizService.getQuizById(id));
    }

    @GetMapping("/{courseId}/getAll")
    public ResponseEntity<List<QuizDTO>> getAllQuizByCourse(@PathVariable String courseId, @RequestBody CourseDTO courseDTO){
        return ResponseEntity.ok(this.quizService.getQuizByCourse(courseDTO));

    }

    @PostMapping("/add")
    public ResponseEntity<QuizDTO> addQuiz(@RequestBody QuizDTO quizDTO){
        return ResponseEntity.ok(this.quizService.addQuiz(quizDTO));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<QuizDTO> updateQuiz(@PathVariable String id, @RequestBody QuizDTO quizDTO){
        return ResponseEntity.ok(this.quizService.updateQuiz(id, quizDTO));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteQuiz(@PathVariable String id){
        this.quizService.deleteQuiz(id);
        return ResponseEntity.ok().build();
    }
}