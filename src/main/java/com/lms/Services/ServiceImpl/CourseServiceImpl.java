package com.lms.Services.ServiceImpl;

import com.github.f4b6a3.ulid.UlidCreator;
import com.lms.DTOs.CourseDTO;
import com.lms.Entities.Course;
import com.lms.Exception.ResourceNotFoundException;
import com.lms.Helper.ModelMappers.CourseMapper;
import com.lms.Repositories.CourseRepository;
import com.lms.Services.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{
    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseDTO addCourse(CourseDTO courseDTO) {
        return CourseMapper.CourseToCourseDTO(this.courseRepository.
                save(Course.builder()
                        .course_id(UlidCreator.getUlid().toString())
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
        return CourseMapper.CourseToCourseDTO(this.courseRepository.save(Course.builder()
                .course_id(id)
                .course_code(courseDTO.getCourse_code())
                .name(courseDTO.getName())
                .description(courseDTO.getDescription())
                .credits(courseDTO.getCredits())
                .build()));
    }

    @Override
    public CourseDTO getCourse(String id) {
        return CourseMapper.CourseToCourseDTO(this.courseRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Course not found with Provided ID: " + id)));
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        return Optional.of(this.courseRepository.findAll())
                .orElse(Collections.emptyList())
                .stream()
                .map(CourseMapper::CourseToCourseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO getCourseByName(String name) {
        return CourseMapper.CourseToCourseDTO(this.courseRepository.findByName(name)
                .orElseThrow(()-> new ResourceNotFoundException("Course not found with Provided Name: " + name)));
    }

    @Override
    public List<CourseDTO> getCourseByCreditsIsLessThanEqual(Float credits) {
        return Optional.ofNullable(this.courseRepository.findByCreditsIsLessThanEqual(credits))
                .orElse(Collections.emptyList())
                .stream().map(CourseMapper::CourseToCourseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getCourseByCreditsIsGreaterThanEqual(Float credits) {
        return Optional.ofNullable(this.courseRepository.findByCreditsIsGreaterThanEqual(credits))
                .orElse(Collections.emptyList())
                .stream().map(CourseMapper::CourseToCourseDTO).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getCourseByCreditsEquals(Float credits) {
        return Optional.ofNullable(this.courseRepository.findByCreditsEquals(credits))
                .orElse(Collections.emptyList())
                .stream().map(CourseMapper::CourseToCourseDTO)
                .collect(Collectors.toList());
    }
}
