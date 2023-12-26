package com.lms.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

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
    @ManyToMany
    private List<Faculty> faculties;
    @ManyToMany
    private List<Student> students;
}
