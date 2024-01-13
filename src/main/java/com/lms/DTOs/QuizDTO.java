package com.lms.DTOs;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class QuizDTO {

    private String quiz_id;
    @NotNull(message = "Total marks cannot be null")
    @DecimalMin(value = "0.0", inclusive = true, message = "Total marks must be greater than of equal to 0")
    private Float total_marks;
    @NotNull(message = "time duration cannot be null")
    @DecimalMin(value = "0.0", inclusive = true, message = "Total time must be greater than of equal to 0")
    private Float total_time;
    @NotNull(message = "Start time cannot be null")
    @Future(message = "Start time must be in the future")
    private Date start_time;
    private Boolean is_active;
    @NotNull(message = "Course cannot be null")
    private CourseDTO course;
}
