package com.lms.Entities;

import com.lms.DTOs.CourseDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
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
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "courseList")
    private List<Faculty> faculties;
}
