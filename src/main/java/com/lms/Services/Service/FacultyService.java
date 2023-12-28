package com.lms.Services.Service;

import com.lms.DTOs.CourseDTO;
import com.lms.DTOs.FacultyDTO;
import com.lms.Entities.Branch;
import com.lms.Exception.BadCredentialsException;

import java.util.List;

public interface FacultyService {

    List<FacultyDTO> getAllFaculties();

    FacultyDTO getFaculty(String id);

    FacultyDTO addFaculty(FacultyDTO facultyDTO);

    FacultyDTO updateFaculty(String id, FacultyDTO facultyDTO);

    void deleteFaculty(String id);

    List<FacultyDTO> getFacultyByName(String name);

    List<FacultyDTO> getFacultyByBranch(Branch branch);

    List<FacultyDTO> getFacultyByCourse(CourseDTO courseDTO);

    FacultyDTO addCourseToFaculty(String faculty_id, List<CourseDTO> courses) throws BadCredentialsException;

    FacultyDTO removeCourseFromFaculty(String faculty_id, CourseDTO courseDTO);

}
