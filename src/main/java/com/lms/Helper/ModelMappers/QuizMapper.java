package com.lms.Helper.ModelMappers;

import com.lms.DTOs.QuizDTO;
import com.lms.Entities.Course;
import com.lms.Entities.Quiz;

import static com.lms.Helper.ModelMappers.CourseMapper.CourseDTOTOCourse;

public class QuizMapper {

    public static QuizDTO QuizToQuizDTO(Quiz quiz){
        return QuizDTO.builder()
                .quiz_id(quiz.getQuizId())
                .total_marks(quiz.getTotalMarks())
                .total_time(quiz.getTotalTime())
                .start_time(quiz.getStartTime())
                .is_active(quiz.getIsActive())
                .Posted_on(quiz.getPostedOn())
                .build();
    }

    public static Quiz QuizDTOToQuiz(QuizDTO quizDTO){
        return Quiz.builder()
                .quizId(quizDTO.getQuiz_id())
                .totalMarks(quizDTO.getTotal_marks())
                .totalTime(quizDTO.getTotal_time())
                .startTime(quizDTO.getStart_time())
                .isActive(quizDTO.getIs_active())
                .PostedOn(quizDTO.getPosted_on())
                .course(CourseDTOTOCourse(quizDTO.getCourse()))
                .build();
    }

    public static Quiz QuizDTOToQuiz(QuizDTO quizDTO, Quiz quiz){
        quiz.setTotalMarks(quizDTO.getTotal_marks());
        quiz.setTotalTime(quizDTO.getTotal_time());
        quiz.setStartTime(quizDTO.getStart_time());
        quiz.setIsActive(quizDTO.getIs_active());
        return quiz;
    }
}
