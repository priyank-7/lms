package com.lms.Services.Service;

import com.lms.DTOs.QuizResultDTO;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface QuizResultService {

    List<QuizResultDTO> getQuizResultByStudent(String student_id, Authentication connectedUser);

    QuizResultDTO addQuizResult(QuizResultDTO quizResultDTO, String student_id, String quiz_id, Authentication connectedUser);

    QuizResultDTO updateQuizResult(QuizResultDTO quizResultDTO, String quizResult_id, Authentication connectedUser);

    void deleteQuizResult(String quizResult_id, Authentication connectedUser);

    QuizResultDTO getQuizResultByQuizAndStudent(String student_id, String course_id, Authentication connectedUser);

    List<QuizResultDTO> getQuizResultByQuiz(String quiz_id, Authentication connectedUser);

    QuizResultDTO getQuizResult(String quizResult_id, Authentication connectedUser);

}
