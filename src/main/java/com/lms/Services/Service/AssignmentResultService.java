package com.lms.Services.Service;


import com.lms.DTOs.AssignmentResultDTO;

import java.util.Date;
import java.util.List;

public interface AssignmentResultService {

    List<AssignmentResultDTO> getAssignmentResultByStudent(String student_id);

    AssignmentResultDTO addAssignmentResult(AssignmentResultDTO assignmentResultDTO, String student_id, String assignment_id);

    AssignmentResultDTO updateAssignmentResult(AssignmentResultDTO assignmentResultDTO, String assignmentResult_id);

    void deleteAssignmentResult(String assignment_id);

    AssignmentResultDTO getAssignmentResultByAssignmentAndStudent(String student_id, String assignment_id);

    List<AssignmentResultDTO> getAssignmentResultByAssignment(String assignment_id);

    AssignmentResultDTO getAssignmentResult(String assignmentResult_id);

}
