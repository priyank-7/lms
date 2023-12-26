package com.lms.Services.ServiceImpl;

import com.lms.DTOs.CourseDTO;
import com.lms.Entities.Course;
import com.lms.Exception.ResourceNotFoundException;
import com.lms.Repositories.CourseRepository;
import com.lms.Services.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseDTO addCourse(CourseDTO courseDTO) {
        return CourseToCourseDTO(this.courseRepository.
                save(Course.builder()
                        .course_id(UUID.randomUUID().toString())
                        .course_code(courseDTO.getCourse_code())
                        .name(courseDTO.getName())
                        .description(courseDTO.getDescription())
                        .credits(courseDTO.getCredits())
                        .build()));
    }

    @Override
    public void deleteCourse(String id) {
        this.courseRepository.delete(this.courseRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Course not found with Provided ID: " + id)));
    }

    @Override
    public CourseDTO updateCourse(String id, CourseDTO courseDTO) {
        this.courseRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Course not found with Provided ID: " + id));
        return CourseToCourseDTO(this.courseRepository.save(Course.builder()
                .course_id(id)
                .course_code(courseDTO.getCourse_code())
                .name(courseDTO.getName())
                .description(courseDTO.getDescription())
                .credits(courseDTO.getCredits())
                .build()));
    }

    @Override
    public CourseDTO getCourse(String id) {
        return CourseToCourseDTO(this.courseRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Course not found with Provided ID: " + id)));
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        return this.courseRepository.findAll()
                .stream()
                .map(course -> CourseToCourseDTO(course))
                .collect(Collectors.toList());
    }

//    @Override
//    public CourseDTO getCourseByCode(String code) {
//        return CourseToCourseDTO(this.courseRepository.findCourseByCourse_code(code)
//                .orElseThrow(()-> new ResourceNotFoundException("Course not found with Provided Code: " + code)));
//    }

    @Override
    public CourseDTO getCourseByName(String name) {
        return CourseToCourseDTO(this.courseRepository.findByName(name)
                .orElseThrow(()-> new ResourceNotFoundException("Course not found with Provided Name: " + name)));
    }

    @Override
    public List<CourseDTO> getCourseByCreditsIsLessThanEqual(Float credits) {
        return this.courseRepository.findByCreditsIsLessThanEqual(credits).stream().map(course -> CourseToCourseDTO(course)).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getCourseByCreditsIsGreaterThanEqual(Float credits) {
        return this.courseRepository.findByCreditsIsGreaterThanEqual(credits).stream().map(course -> CourseToCourseDTO(course)).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getCourseByCreditsEquals(Float credits) {
        return this.courseRepository.findByCreditsEquals(credits).stream().map(course -> CourseToCourseDTO(course)).collect(Collectors.toList());
    }

    public static CourseDTO CourseToCourseDTO(Course course){
        return CourseDTO.builder()
                .course_id(course.getCourse_id())
                .course_code(course.getCourse_code())
                .name(course.getName())
                .description(course.getDescription())
                .credits(course.getCredits())
                .build();
    }
}
