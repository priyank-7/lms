package com.lms.Helper.ModelMappers;

import com.lms.DTOs.AssignmentDTO;
import com.lms.Entities.Assignment;

public class AssignmentMapper {

    public static AssignmentDTO AssignmentToAssignmentDTO(Assignment assignment){
        return AssignmentDTO.builder()
                .assignment_id(assignment.getAssignment_id())
                .assign_date(assignment.getAssign_date())
                .submission_date(assignment.getSubmission_date())
                .total_marks(assignment.getTotal_marks())
                .build();
    }

    public static Assignment AssignmentDTOTOAssignment(AssignmentDTO assignmentDTO){
        return Assignment.builder()
                .assignment_id(assignmentDTO.getAssignment_id())
                .total_marks(assignmentDTO.getTotal_marks())
                .assign_date(assignmentDTO.getAssign_date())
                .submission_date(assignmentDTO.getSubmission_date())
                .course(CourseMapper.CourseDTOTOCourse(assignmentDTO.getCourse()))
                .build();
    }

    public static Assignment AssignmentDTOTOAssignment(Assignment assignment, AssignmentDTO assignmentDTO){
        assignment.setTotal_marks(assignmentDTO.getTotal_marks());
        assignment.setSubmission_date(assignmentDTO.getSubmission_date());
        return assignment;
    }
}
