package com.lms.DTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CourseDTO {

    private String id;
    @NotBlank(message = "Course name cannot be blank")
    private String name;
    private String description;
    private Float credits;
}
