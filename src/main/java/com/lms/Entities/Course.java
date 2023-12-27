package com.lms.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Course {

    @Id
    private String course_id;
    @NotBlank
    @Column(unique = true)
    private String course_code;
    @NotBlank
    private String name;
    private String description;
    private Float credits;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "courseList")
    private List<Faculty> faculties;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "courseList")
    private List<Student> students;
}
