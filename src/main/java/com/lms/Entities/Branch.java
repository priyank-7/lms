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
@ToString
@Entity
public class Branch {

    @Id
    private String branch_id;
    @NotBlank
    @Column(unique = true)
    private String name;
}
