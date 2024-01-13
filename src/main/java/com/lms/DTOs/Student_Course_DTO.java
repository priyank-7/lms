package com.lms.DTOs;

import com.lms.Entities.Course;
import com.lms.Entities.Student_Course_PK;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student_Course_DTO {

    private Student_Course_PK student_course_pk;
    private Course course;
}
