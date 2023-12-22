package com.lms.Entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Assignment_Result {

    @EmbeddedId
    private PK_Number_Course_Student assignment_id;
    private Float obtained_marks;
    private Boolean is_submitted;
    private Date submission_date;
}
