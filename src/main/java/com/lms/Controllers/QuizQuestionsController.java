package com.lms.Controllers;


import com.lms.Services.ServiceImpl.QuizQuestionsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz-questions")
public class QuizQuestionsController {

    private final QuizQuestionsServiceImpl quizQuestionsService;


    @Autowired
    public QuizQuestionsController(QuizQuestionsServiceImpl quizQuestionsService){
        this.quizQuestionsService = quizQuestionsService;
    }


    @PostMapping
    public void saveQuizQuestions(){
        //TODO
    }

    @GetMapping()
    public void getQuizQuestions(){
        //TODO
    }
}
