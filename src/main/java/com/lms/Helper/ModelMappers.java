package com.lms.Helper;

import com.lms.DTOs.AssignmentDTO;
import com.lms.DTOs.CourseDTO;
import com.lms.DTOs.FacultyDTO;
import com.lms.Entities.*;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

public class ModelMappers {

    public static FacultyDTO FacultyToFacultyDTO(Faculty faculty){
        return FacultyDTO.builder()
                .faculty_id(faculty.getId())
                .name(faculty.getName())
                .email(faculty.getEmail())
                .phone(faculty.getPhone())
                .dob(faculty.getDob())
                .address(faculty.getAddress())
                .branch(faculty.getBranch())
                .joining_date(faculty.getJoining_date())
                .gender(faculty.getGender())
                .qualification(faculty.getQualification())
                .image_url(faculty.getImage_url())
                .courseList(
                        Optional.ofNullable(faculty.getCourseList())
                                .orElse(Collections.emptyList())
                                .stream().map(course -> CourseToCourseDTO(course))
                                .collect(Collectors.toList()))
                .build();
    }

    public static Faculty FacultyDTOTOFaculty(FacultyDTO facultyDTO){
        return Faculty.builder()
                .id(facultyDTO.getFaculty_id())
                .name(facultyDTO.getName())
                .email(facultyDTO.getEmail())
                .phone(facultyDTO.getPhone())
                .dob(facultyDTO.getDob())
                .address(facultyDTO.getAddress())
                .branch(facultyDTO.getBranch())
                .joining_date(facultyDTO.getJoining_date())
                .gender(facultyDTO.getGender())
                .qualification(facultyDTO.getQualification())
                .image_url(facultyDTO.getImage_url())
                .build();
    }

    public static Faculty FacultyDTOTOFaculty(Faculty faculty, FacultyDTO facultyDTO){
        faculty.setId(facultyDTO.getFaculty_id());
        faculty.setName(facultyDTO.getName());
        faculty.setEmail(facultyDTO.getEmail());
        faculty.setPhone(facultyDTO.getPhone());
        faculty.setDob(facultyDTO.getDob());
        faculty.setAddress(facultyDTO.getAddress());
        faculty.setBranch(facultyDTO.getBranch());
        faculty.setJoining_date(facultyDTO.getJoining_date());
        faculty.setGender(facultyDTO.getGender());
        faculty.setQualification(facultyDTO.getQualification());
        faculty.setImage_url(facultyDTO.getImage_url());
        return faculty;
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
