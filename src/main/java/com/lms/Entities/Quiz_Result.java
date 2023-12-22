package com.lms.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private PK_Number_Course_Student quiz_id;
    private Float obtained_marks;
    private Boolean is_submitted;
    private Date submission_date;
}
