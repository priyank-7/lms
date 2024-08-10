package com.lms.Services.Service;

import com.lms.Entities.QuizQuestions;
import org.springframework.security.core.Authentication;

public interface QuizQuestionsService {

    QuizQuestions saveQuizQuestions(QuizQuestions quizQuestions, Authentication connectedUser);

    QuizQuestions getQuizQuestions(String quizId, Authentication connectedUser);

    QuizQuestions updateQuizQuestions(QuizQuestions quizQuestions, Authentication connectedUser);
}
