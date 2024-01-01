package com.lms.Services.Service;

import com.lms.DTOs.CourseDTO;

import java.util.List;

public interface CourseService {

    CourseDTO addCourse(CourseDTO courseDTO);

    void deleteCourse(String id);

    CourseDTO updateCourse(String id, CourseDTO courseDTO);

    CourseDTO getCourse(String id);

    List<CourseDTO> getAllCourses();

    CourseDTO getCourseByName(String name);

    List<CourseDTO> getCourseByCreditsIsLessThanEqual(Float credits);

    List<CourseDTO> getCourseByCreditsIsGreaterThanEqual(Float credits);

    List<CourseDTO> getCourseByCreditsEquals(Float credits);
}
