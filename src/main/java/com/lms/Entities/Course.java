package com.lms.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
    private String name;
    private String description;
    private Float credits;
    @ManyToMany
    private List<Faculty> faculties;
    @ManyToMany
    private List<Student> students;
}
