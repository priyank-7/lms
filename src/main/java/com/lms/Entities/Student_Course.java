package com.lms.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@AssociationOverrides({
        @AssociationOverride(name="student_course_pk.student",
                joinColumns = @JoinColumn(name="student_id")),
        @AssociationOverride(name="student_course_pk.course",
                joinColumns = @JoinColumn(name="course_id"))
})
public class Student_Course {

    @EmbeddedId
    private Student_Course_PK student_course_pk;
    @Column(nullable = false)
    private Date enroll_date;

}
