package com.lms.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Result {

    @EmbeddedId
    @JsonIgnore(value = false)
    private PK_Result resultId;
    private Float totalMarks;
    private Float obtainedMarks;
    private String grade;
    private Boolean isPassed;
    private Date postedOn;
}
