package com.lms.DTOs;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Builder
@Getter
@Setter
public class AssignmentDTO implements Serializable {

    private String assignment_id;
    @NotNull(message = "Total marks cannot be null")
    @DecimalMin(value = "0.0", inclusive = true, message = "Total marks must be greater than of equal to 0")
    private Float total_marks;
    private Date assign_date;
    @NotNull(message = "Submission date cannot be null")
    @Future(message = "Submission date must be in the future")
    private Date submission_date;
    @NotNull(message = "Course cannot be null")
    private CourseDTO course;
}
