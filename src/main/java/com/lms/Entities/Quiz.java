package com.lms.Entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.Date;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Quiz {

    @Id
    private String quizId;
    @ManyToOne
    private Course course;
    private Float totalMarks;
    private Float totalTime;
    private Date startTime;
    private Date PostedOn;
    private Boolean isActive;


}
