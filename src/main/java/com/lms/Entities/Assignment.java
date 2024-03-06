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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Assignment {

    @Id
    private String assignmentId;
    @ManyToOne
    private Course course;
    private Float totalMarks;
    private Date assignDate;
    private Date submissionDate;
}
