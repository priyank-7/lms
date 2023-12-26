package com.lms.Services.Service;

import com.lms.DTOs.CourseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    CourseDTO addCourse(CourseDTO courseDTO);

    void deleteCourse(String id);

    CourseDTO updateCourse(String id, CourseDTO courseDTO);

    CourseDTO getCourse(String id);

    List<CourseDTO> getAllCourses();

//    CourseDTO getCourseByCode(String code);

    CourseDTO getCourseByName(String name);

    List<CourseDTO> getCourseByCreditsIsLessThanEqual(Float credits);

    List<CourseDTO> getCourseByCreditsIsGreaterThanEqual(Float credits);

    List<CourseDTO> getCourseByCreditsEquals(Float credits);

}
