package com.lms.Helper.ModelMappers;

import com.lms.DTOs.CourseDTO;
import com.lms.DTOs.FacultyDTO;
import com.lms.Entities.Course;
import com.lms.Entities.Faculty;

public class CourseMapper {
    public static CourseDTO CourseToCourseDTO(Course course){
        return CourseDTO.builder()
                .course_id(course.getCourse_id())
                .course_code(course.getCourse_code())
                .name(course.getName())
                .description(course.getDescription())
                .credits(course.getCredits())
                .build();
    }

    public static Course CourseDTOTOCourse(CourseDTO courseDTO){
        return Course.builder()
                .course_id(courseDTO.getCourse_id())
                .course_code(courseDTO.getCourse_code())
                .name(courseDTO.getName())
                .description(courseDTO.getDescription())
                .credits(courseDTO.getCredits())
                .build();
    }

    public static FacultyDTO CourseFacultyToFacultyDTO(Faculty faculty){
        return FacultyDTO.builder()
                .faculty_id(faculty.getId())
                .name(faculty.getName())
                .email(faculty.getEmail())
                .phone(faculty.getPhone())
                .build();
    }
}
