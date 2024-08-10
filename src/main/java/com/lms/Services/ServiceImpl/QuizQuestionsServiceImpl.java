package com.lms.Services.ServiceImpl;


import com.lms.Entities.QuizQuestions;
import com.lms.Repositories.QuizQuestionsRepository;
import com.lms.Services.Service.QuizQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class QuizQuestionsServiceImpl implements QuizQuestionsService {

    private final QuizQuestionsRepository quizQuestionsRepository;

    @Autowired
    public QuizQuestionsServiceImpl(QuizQuestionsRepository quizQuestionsRepository){
        this.quizQuestionsRepository = quizQuestionsRepository;
    }
    @Override
    public QuizQuestions saveQuizQuestions(QuizQuestions quizQuestions, Authentication connectedUser) {

        // TODO : Check User has permission to add QuizQuestions

        return this.quizQuestionsRepository.save(quizQuestions);
    }

    @Override
    public QuizQuestions getQuizQuestions(String quizId, Authentication connectedUser) {

        // TODO : Check User has permission to get QuizQuestions
        return null;
    }

    @Override
    public QuizQuestions updateQuizQuestions(QuizQuestions quizQuestions, Authentication connectedUser) {

        // TODO : Check User has permission to update QuizQuestions
        return null;
    }
}
