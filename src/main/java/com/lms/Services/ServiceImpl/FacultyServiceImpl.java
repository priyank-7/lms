package com.lms.Services.ServiceImpl;

import com.lms.DTOs.CourseDTO;
import com.lms.DTOs.FacultyDTO;
import com.lms.Entities.Branch;
import com.lms.Entities.Faculty;
import com.lms.Exception.ResourceNotFoundException;
import com.lms.Repositories.BranchRepository;
import com.lms.Repositories.CourseRepository;
import com.lms.Repositories.FacultyRepository;
import com.lms.Services.Service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;
    private final BranchRepository branchRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public FacultyServiceImpl(FacultyRepository facultyRepository, BranchRepository branchRepository, CourseRepository courseRepository) {
        this.facultyRepository = facultyRepository;
        this.branchRepository = branchRepository;
        this.courseRepository = courseRepository;
    }
    @Override
    public List<FacultyDTO> getAllFaculties() {
        return this.facultyRepository.findAll().stream().map(faculty -> FacultyToFacultyDTO(faculty)).collect(Collectors.toList());
    }

    @Override
    public FacultyDTO getFaculty(String id) {
        return FacultyToFacultyDTO(this.facultyRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Faculty not found")));
    }

    @Override
    public FacultyDTO addFaculty(FacultyDTO facultyDTO) {
        facultyDTO.setFaculty_id(UUID.randomUUID().toString());
        return FacultyToFacultyDTO(this.facultyRepository.save(FacultyDTOTOFaculty(facultyDTO)));
    }

    @Override
    public FacultyDTO updateFaculty(String id, FacultyDTO facultyDTO) {
        this.facultyRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Faculty not found"));
        facultyDTO.setFaculty_id(id);
        return FacultyToFacultyDTO(this.facultyRepository.save(FacultyDTOTOFaculty(facultyDTO)));
    }

    @Override
    public void deleteFaculty(String id) {
        this.facultyRepository.delete(this.facultyRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Faculty not found with Provided ID: " + id)));
    }

    @Override
    public List<FacultyDTO> getFacultyByName(String name) {
        return this.facultyRepository.findByName(name).stream().map(faculty -> FacultyToFacultyDTO(faculty)).collect(Collectors.toList());
    }

    @Override
    public List<FacultyDTO> getFacultyByBranch(Branch branch) {
        return this.facultyRepository.findFacultiesByBranch(
                this.branchRepository.findById(branch.getBranch_id())
                        .orElseThrow(()-> new ResourceNotFoundException("Branch not found with Provided ID: " + branch.getBranch_id())))
                .stream()
                .map(faculty -> FacultyToFacultyDTO(faculty))
                .collect(Collectors.toList());
    }

    @Override
    public List<FacultyDTO> getFacultyByCourse(CourseDTO courseDTO) {
        return this.facultyRepository.findFacultiesByCourseListIsContaining(
                this.courseRepository.findById(courseDTO.getCourse_id()).orElseThrow(()-> new ResourceNotFoundException("Course not found")))
                .stream()
                .map(faculty -> FacultyToFacultyDTO(faculty))
                .collect(Collectors.toList());
    }

    @Override
    public FacultyDTO addCourseToFaculty(String faculty_id, List<CourseDTO> courses) {
                Faculty temp = this.facultyRepository.findById(faculty_id)
                .orElseThrow(()-> new ResourceNotFoundException("Faculty not found with Provided ID: " + faculty_id));
                temp.setCourseList(courses.stream().map(courseDTO -> CourseServiceImpl.CourseDTOTOCourse(courseDTO)).collect(Collectors.toList()));
                return FacultyToFacultyDTO(this.facultyRepository.save(temp));
    }

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
                .courseList(Optional.ofNullable(faculty.getCourseList()).orElse(Collections.emptyList()).stream().map(course -> CourseServiceImpl.CourseToCourseDTO(course)).collect(Collectors.toList()))
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
}
