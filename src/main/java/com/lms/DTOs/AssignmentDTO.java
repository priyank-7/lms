package com.lms.DTOs;

import com.lms.Entities.Course;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class AssignmentDTO {

    private String assignment_number;
    @NotNull(message = "Total marks cannot be null")
    private Float total_marks;
    @NotNull(message = "Assign date cannot be null")
    private Date assign_date;
    @NotNull(message = "Submission date cannot be null")
    @Future(message = "Submission date must be in the future")
    private Date submission_date;
    @NotNull(message = "Course cannot be null")
    private Course course;
}
