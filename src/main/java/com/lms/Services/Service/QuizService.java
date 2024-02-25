package com.lms.Services.Service;

import com.lms.DTOs.CourseDTO;
import com.lms.DTOs.QuizDTO;

import java.util.List;

public interface QuizService {

    List<QuizDTO> getAllQuizzes();

    QuizDTO getQuizById(String id);

    QuizDTO addQuiz(QuizDTO quizDTO, String courseId);

    QuizDTO updateQuiz(String id, QuizDTO quizDTO);

    void deleteQuiz(String id);

    List<QuizDTO> getQuizByCourse(CourseDTO course);
}
