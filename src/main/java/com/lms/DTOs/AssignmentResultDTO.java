package com.lms.DTOs;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
public class AssignmentResultDTO {

    private String assignmentResult_id;
    @NotNull(message = "Obtained marks cannot be null")
    private Float obtained_marks;
    private Boolean is_submitted;
    private Date postedOn;
    @NotNull(message = "SubmittedOn cannot be null")
    @PastOrPresent(message = "SubmittedOn must be in the past")
    private Date submittedOn;
    private AssignmentDTO assignment;
    private StudentDTO student;
}
