package com.lms.Services.Service;

import java.util.List;

public interface FacultyService {

    List<FacultyService> getAllFaculties();

    FacultyService getFaculty(String id);

    void addFaculty(FacultyService facultyDTO);

    void updateFaculty(String id, FacultyService facultyDTO);

    void deleteFaculty(String id);

    FacultyService getFacultyByBranch(String branchId);

    FacultyService getFacultyByName(String name);

}
