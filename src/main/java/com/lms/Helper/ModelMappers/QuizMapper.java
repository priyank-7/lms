package com.lms.Helper.ModelMappers;

import com.lms.DTOs.QuizDTO;
import com.lms.Entities.Quiz;
import com.lms.Helper.ModelMapper;

public class QuizMapper {

    public static QuizDTO QuizToQuizDTO(Quiz quiz){
        return QuizDTO.builder()
                .quiz_id(quiz.getQuiz_id())
                .total_marks(quiz.getTotal_marks())
                .total_time(quiz.getTotal_time())
                .start_time(quiz.getStart_time())
                .is_active(quiz.getIs_active())
                .build();
    }

    public static Quiz QuizDTOToQuiz(QuizDTO quizDTO){
        return Quiz.builder()
                .quiz_id(quizDTO.getQuiz_id())
                .total_marks(quizDTO.getTotal_marks())
                .total_time(quizDTO.getTotal_time())
                .start_time(quizDTO.getStart_time())
                .is_active(quizDTO.getIs_active())
                .build();
    }

    public static Quiz QuizDTOToQuiz(QuizDTO quizDTO, Quiz quiz){
        quiz.setTotal_marks(quizDTO.getTotal_marks());
        quiz.setTotal_time(quizDTO.getTotal_time());
        quiz.setStart_time(quizDTO.getStart_time());
        quiz.setIs_active(quizDTO.getIs_active());
        quiz.setCourse(ModelMapper.CourseDTOTOCourse(quizDTO.getCourse()));
        return quiz;
    }
}
