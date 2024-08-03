package com.lms.Services.Service;

import com.lms.DTOs.CourseDTO;
import com.lms.DTOs.QuizDTO;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface QuizService {

    QuizDTO getQuizById(String id, Authentication connectedUser);

    QuizDTO addQuiz(QuizDTO quizDTO, String courseId, Authentication connectedUser);

    QuizDTO updateQuiz(String id, QuizDTO quizDTO, Authentication connectedUser);

    void deleteQuiz(String id, Authentication connectedUser);

    List<QuizDTO> getQuizByCourse(String courseId, Authentication connectedUser);
}
