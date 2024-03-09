package com.lms.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Quiz_Result {

    @Id
    private String quizId;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Quiz quiz;
    private Float obtainedMarks;
    private Date PostedOn;
    private Boolean isSubmitted;
    private Date submittedOn;
}
