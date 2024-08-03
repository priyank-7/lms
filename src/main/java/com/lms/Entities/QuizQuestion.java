package com.lms.Entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@Setter
@ToString
public class QuizQuestion {

    @NotNull(message = "Question ID is required")
    private String questionId;

    @NotNull(message = "Question is required")
    @NotBlank(message = "Question is required")
    private String question;

    @NotNull(message = "Question type is required")
    private boolean isMultipleChoice;

    private List<String> options;
}
