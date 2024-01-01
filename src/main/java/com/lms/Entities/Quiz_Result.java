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
    private String quiz_id;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Course course;
    private Float obtained_marks;
    private Boolean is_submitted;
    private Date submission_date;
}
