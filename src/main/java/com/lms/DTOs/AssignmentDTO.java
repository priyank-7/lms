package com.lms.DTOs;

import com.lms.Entities.Course;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class AssignmentDTO {

    private Integer assignment_number;
    private Float total_marks;
    private String assign_date;
    private Date submission_date;
    private Course course;
}
