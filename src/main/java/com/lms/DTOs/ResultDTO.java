package com.lms.DTOs;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Builder
@Getter
@Setter
public class ResultDTO implements Serializable{

    private String studentId;
    private String courseId;
    @NotNull(message = "Total marks should not be null")
    @PositiveOrZero(message = "Total marks should be positive or zero")
    private Float totalMarks;
    @NotNull(message = "Obtained marks should not be null")
    private Float obtainedMarks;
    private String grade;
    private Boolean isPassed;
    private Date postedOn;
}
