package com.lms.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Branch {

    @Id
    private String branch_id;
    @NotBlank
    @Column(unique = true)
    private String name;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "branch")
    @JsonIgnore(value = false)
    private List<Student> students;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "branch")
    @JsonIgnore(value = false)
    private List<Faculty> faculties;
}
