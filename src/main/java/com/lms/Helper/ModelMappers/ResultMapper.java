package com.lms.Helper.ModelMappers;

import com.lms.DTOs.ResultDTO;
import com.lms.Entities.Course;
import com.lms.Entities.PK_Result;
import com.lms.Entities.Result;
import com.lms.Entities.Student;

public class ResultMapper {

    public static PK_Result mapToPKResult(Student student, Course course) {
        return PK_Result.builder()
                .student(student)
                .course(course)
                .build();
    }

    public static ResultDTO ResultTOResultDTO(Result result) {
        return ResultDTO.builder()
                .studentId(result.getResultId().getStudent().getStudent_id())
                .courseId(result.getResultId().getCourse().getCourse_id())
                .totalMarks(result.getTotalMarks())
                .obtainedMarks(result.getObtainedMarks())
                .grade(result.getGrade())
                .isPassed(result.getIsPassed())
                .postedOn(result.getPostedOn())
                .build();
    }

    public static Result ResultDTOToResult(ResultDTO resultDTO, Student student, Course course) {
        return Result.builder()
                .resultId(PK_Result.builder()
                        .student(student)
                        .course(course)
                        .build())
                .totalMarks(resultDTO.getTotalMarks())
                .obtainedMarks(resultDTO.getObtainedMarks())
                .grade(resultDTO.getGrade())
                .isPassed(resultDTO.getIsPassed())
                .postedOn(resultDTO.getPostedOn())
                .build();
    }

    public static Result ResultDTOTOResult(Result result, ResultDTO resultDTO) {
        result.setTotalMarks(resultDTO.getTotalMarks());
        result.setObtainedMarks(resultDTO.getObtainedMarks());
        result.setGrade(resultDTO.getGrade());
        result.setIsPassed(resultDTO.getIsPassed());
        result.setPostedOn(resultDTO.getPostedOn());
        return result;
    }
}
