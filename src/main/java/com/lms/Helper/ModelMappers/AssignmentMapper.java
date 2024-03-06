package com.lms.Helper.ModelMappers;

import com.lms.DTOs.AssignmentDTO;
import com.lms.Entities.Assignment;

public class AssignmentMapper {

    public static AssignmentDTO AssignmentToAssignmentDTO(Assignment assignment){
        return AssignmentDTO.builder()
                .assignment_id(assignment.getAssignmentId())
                .assign_date(assignment.getAssignDate())
                .submission_date(assignment.getSubmissionDate())
                .total_marks(assignment.getTotalMarks())
                .course(CourseMapper.CourseToCourseDTO(assignment.getCourse()))
                .build();
    }

    public static Assignment AssignmentDTOTOAssignment(AssignmentDTO assignmentDTO){
        return Assignment.builder()
                .assignmentId(assignmentDTO.getAssignment_id())
                .totalMarks(assignmentDTO.getTotal_marks())
                .assignDate(assignmentDTO.getAssign_date())
                .submissionDate(assignmentDTO.getSubmission_date())
                .course(CourseMapper.CourseDTOTOCourse(assignmentDTO.getCourse()))
                .build();
    }

    public static Assignment AssignmentDTOTOAssignment(Assignment assignment, AssignmentDTO assignmentDTO){
        assignment.setTotalMarks(assignmentDTO.getTotal_marks());
        assignment.setSubmissionDate(assignmentDTO.getSubmission_date());
        return assignment;
    }
}
