package com.lms.Services.Service;

import com.lms.DTOs.QuizResultDTO;

import java.util.List;

public interface QuizResultService {

    List<QuizResultDTO> getQuizResultByStudent(String student_id);

    QuizResultDTO addQuizResult(QuizResultDTO quizResultDTO, String student_id, String quiz_id);

    QuizResultDTO updateQuizResult(QuizResultDTO quizResultDTO, String quizResult_id);

    void deleteQuizResult(String quizResult_id);

    QuizResultDTO getQuizResultByQuizAndStudent(String student_id, String course_id);

    List<QuizResultDTO> getQuizResultByQuiz(String quiz_id);

    QuizResultDTO getQuizResult(String quizResult_id);

}
