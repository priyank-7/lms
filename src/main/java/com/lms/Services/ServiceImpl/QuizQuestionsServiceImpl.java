package com.lms.Services.ServiceImpl;


import com.lms.Entities.QuizQuestions;
import com.lms.Repositories.QuizQuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizQuestionsServiceImpl {

    private final QuizQuestionsRepository quizQuestionsRepository;

    @Autowired
    public QuizQuestionsServiceImpl(QuizQuestionsRepository quizQuestionsRepository){
        this.quizQuestionsRepository = quizQuestionsRepository;
    }


    public QuizQuestions saveQuizQuestions(QuizQuestions quizQuestions){
        return quizQuestionsRepository.save(quizQuestions);
    }

}
