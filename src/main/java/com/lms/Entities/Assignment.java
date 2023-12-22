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
public class Assignment {

    @EmbeddedId
    private PK_Number_Course assignment_id;
    private Float total_marks;
    private Date assign_date;
    private Date submission_date;
}
