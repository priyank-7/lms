package com.lms.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Assignment_Result {

    @Id
    private String assignment_id;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Course course;
    private Float obtained_marks;
    private Boolean is_submitted;
    private Date submission_date;
}
