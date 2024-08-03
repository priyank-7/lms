package com.lms.Entities;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Document(collection = "QuizQuestions")
public class QuizQuestions {

    @NotNull(message = "Quiz ID is required")
    private String quizId;

    @NotNull(message = "Questions are required")
    List<QuizQuestion> questions;
}
