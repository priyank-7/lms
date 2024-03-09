package com.lms.Helper.ModelMappers;

import com.lms.DTOs.QuizResultDTO;
import com.lms.Entities.Quiz;
import com.lms.Entities.Quiz_Result;
import com.lms.Entities.Student;

public class QuizResultMapper {

    public static Quiz_Result QuizResultDTOTOQuizResult(QuizResultDTO quizResultDTO, Student student, Quiz quiz){
        return Quiz_Result.builder()
                .quizId(quizResultDTO.getQuizResult_id())
                .isSubmitted(quizResultDTO.getIs_submitted())
                .obtainedMarks(quizResultDTO.getObtained_marks())
                .PostedOn(quizResultDTO.getPostedOn())
                .submittedOn(quizResultDTO.getSubmittedOn())
                .quiz(quiz)
                .student(student)
                .build();
    }

    public static QuizResultDTO QuizResultToQuizResultDTO(Quiz_Result quizResult){
        return QuizResultDTO.builder()
                .quizResult_id(quizResult.getQuizId())
                .is_submitted(quizResult.getIsSubmitted())
                .obtained_marks(quizResult.getObtainedMarks())
                .postedOn(quizResult.getPostedOn())
                .submittedOn(quizResult.getSubmittedOn())
                .student(StudentMapper.StudentToStudentDTOResults(quizResult.getStudent()))
                .build();
    }

    public static Quiz_Result updateQuizResultFromDTO(Quiz_Result quizResult, QuizResultDTO quizResultDTO){
        quizResult.setIsSubmitted(quizResultDTO.getIs_submitted());
        quizResult.setObtainedMarks(quizResultDTO.getObtained_marks());
        quizResult.setPostedOn(quizResultDTO.getPostedOn());
        return quizResult;
    }

}
