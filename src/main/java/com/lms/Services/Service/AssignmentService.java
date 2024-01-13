package com.lms.Services.Service;

import com.lms.DTOs.AssignmentDTO;
import com.lms.DTOs.CourseDTO;
import com.lms.Entities.Course;

import java.util.Date;
import java.util.List;

public interface AssignmentService {

    AssignmentDTO addAssignment(AssignmentDTO assignmentDTO);

    AssignmentDTO updateAssignment(String assignment_id, AssignmentDTO assignmentDTO);

    AssignmentDTO getAssignmentById(String id);

    void deleteAssignment(String id);

    List<AssignmentDTO> getAllAssignments();

    List<AssignmentDTO> getAssignmentsByCourse(Course course);

    List<AssignmentDTO> getAssignmentsByCourseAssignDateGreaterThen(CourseDTO course, String courseId);
}
