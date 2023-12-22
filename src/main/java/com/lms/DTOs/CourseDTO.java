package com.lms.DTOs;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CourseDTO {

    private String id;
    private String name;
    private String description;
    private Float credits;
}
