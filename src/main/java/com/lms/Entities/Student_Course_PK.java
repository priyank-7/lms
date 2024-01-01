package com.lms.Entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student_Course_PK implements Serializable {

    @ManyToOne
    private Student student;
    @ManyToOne
    private Course course;
}
