package com.lms.DTOs;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BranchDTO {

    private String branch_id;
    @NotNull(message = "Branch name is required")
    private String name;
}
