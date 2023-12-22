package com.lms.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Branch {

    @Id
    private String branch_id;
    @NotBlank
    private String name;
    @OneToMany
    private List<Student> students;
    @OneToMany
    private List<Faculty> faculties;
}
