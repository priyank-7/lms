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
    private String assignmentId;
    @ManyToOne
    private Student student;
    private Float obtainedMarks;
    private Boolean isSubmitted;
    private Date submissionDate;
    private Date postedOn;
    @ManyToOne
    private Assignment assignment;
}
