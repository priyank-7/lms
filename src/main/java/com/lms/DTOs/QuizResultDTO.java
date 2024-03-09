package com.lms.DTOs;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class QuizResultDTO {

    private String quizResult_id;
    @NotNull(message = "Obtained marks cannot be null")
    private Float obtained_marks;
    private Boolean is_submitted;
    private Date postedOn;
    @NotNull(message = "SubmittedOn cannot be null")
    @PastOrPresent(message = "SubmittedOn should be in the past or present")
    private Date submittedOn;
    private QuizDTO quiz;
    private StudentDTO student;

}
