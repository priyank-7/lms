package com.lms.Services.Service;

import com.lms.DTOs.CourseDTO;

import java.util.List;

public interface CourseService {

    CourseDTO addCourse(CourseDTO courseDTO);

    void deleteCourse(String id);

    void updateCourse(String id, CourseDTO courseDTO);

    CourseDTO getCourse(String id);

    List<CourseDTO> getAllCourses();

    CourseDTO getCourseByName(String name);

    CourseDTO getCourseByCreditsIsLessThanEqual(Float credits);

    CourseDTO getCourseByCreditsIsGreaterThanEqual(Float credits);

    CourseDTO getCourseByCreditsEquals(Float credits);

}
