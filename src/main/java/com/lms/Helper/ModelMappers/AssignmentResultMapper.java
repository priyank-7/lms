package com.lms.Helper.ModelMappers;

import com.lms.DTOs.AssignmentResultDTO;
import com.lms.Entities.Assignment;
import com.lms.Entities.Assignment_Result;
import com.lms.Entities.Student;

public class AssignmentResultMapper {

    public static Assignment_Result AssignmentResultDTOToAssignmentResult(AssignmentResultDTO assignmentResultDTO, Student student, Assignment assignment) {
        return Assignment_Result.builder()
                .assignmentId(assignmentResultDTO.getAssignmentResult_id())
                .obtainedMarks(assignmentResultDTO.getObtained_marks())
                .isSubmitted(assignmentResultDTO.getIs_submitted())
                .submissionDate(assignmentResultDTO.getSubmittedOn())
                .student(student)
                .assignment(assignment)
                .build();
    }

    public static AssignmentResultDTO AssignmentResultToAssignmentResultDTO(Assignment_Result assignmentResult) {
        return AssignmentResultDTO.builder()
                .assignmentResult_id(assignmentResult.getAssignmentId())
                .obtained_marks(assignmentResult.getObtainedMarks())
                .is_submitted(assignmentResult.getIsSubmitted())
                .submittedOn(assignmentResult.getSubmissionDate())
                .build();
    }

    public static Assignment_Result updateAssignmentResultFromDTO(Assignment_Result assignmentResult, AssignmentResultDTO assignmentResultDTO) {
        assignmentResult.setObtainedMarks(assignmentResultDTO.getObtained_marks());
        assignmentResult.setIsSubmitted(assignmentResultDTO.getIs_submitted());
        assignmentResult.setPostedOn(assignmentResultDTO.getPostedOn());
        return assignmentResult;
    }
}
