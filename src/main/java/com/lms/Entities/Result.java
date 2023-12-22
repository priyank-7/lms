package com.lms.Entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Result {

    @EmbeddedId
    private PK_Result result_id;
    private Float total_marks;
    private Float obtained_marks;
    private String grade;
    private Boolean is_passed;
}
