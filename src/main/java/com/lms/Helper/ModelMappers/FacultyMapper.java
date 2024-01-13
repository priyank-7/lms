package com.lms.Helper.ModelMappers;

import com.lms.DTOs.FacultyDTO;
import com.lms.Entities.Faculty;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

public class FacultyMapper {

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
                                .stream().map(course -> CourseMapper.CourseToCourseDTO(course))
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
}
