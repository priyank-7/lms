package com.lms.DTOs;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class CourseDTO {

    private String course_id;
    @NotBlank(message = "Course code cannot be blank")
    private String course_code;
    @NotBlank(message = "Course name cannot be blank")
    private String name;
    private String description;
    @NotNull(message = "Credits cannot be null")
    @PositiveOrZero(message = "Credits must be positive or zero")
    private Float credits;
    private List<FacultyDTO> faculties;
}
