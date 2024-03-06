package com.lms.Services.ServiceImpl;

import com.github.f4b6a3.ulid.UlidCreator;
import com.lms.DTOs.CourseDTO;
import com.lms.DTOs.FacultyDTO;
import com.lms.Entities.Branch;
import com.lms.Entities.Faculty;
import com.lms.Exception.BadCredentialsException;
import com.lms.Exception.ResourceNotFoundException;
import com.lms.Helper.ModelMappers.CourseMapper;
import com.lms.Helper.ModelMappers.FacultyMapper;
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

    HashSet<Integer> set = new HashSet<>();



    @Autowired
    public FacultyServiceImpl(FacultyRepository facultyRepository, BranchRepository branchRepository, CourseRepository courseRepository) {
        this.facultyRepository = facultyRepository;
        this.branchRepository = branchRepository;
        this.courseRepository = courseRepository;
    }
    @Override
    public List<FacultyDTO> getAllFaculties() {
        return this.facultyRepository.findAll()
                .stream()
                .map(FacultyMapper::FacultyToFacultyDTO).collect(Collectors.toList());
    }

    @Override
    public FacultyDTO getFaculty(String id) {
        return FacultyMapper.FacultyToFacultyDTO(this.facultyRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Faculty not found")));
    }

    @Override
    public FacultyDTO addFaculty(FacultyDTO facultyDTO) {
        facultyDTO.setFaculty_id(UlidCreator.getUlid().toString());
        return FacultyMapper.FacultyToFacultyDTO(this.facultyRepository.save(FacultyMapper.FacultyDTOTOFaculty(facultyDTO)));
    }

    @Override
    public FacultyDTO updateFaculty(String id, FacultyDTO facultyDTO) {
        facultyDTO.setFaculty_id(id);
        return FacultyMapper.FacultyToFacultyDTO(
                this.facultyRepository.save(
                        FacultyMapper.FacultyDTOTOFaculty(
                                this.facultyRepository.findById(id)
                                        .orElseThrow(()-> new ResourceNotFoundException("Faculty not found")),facultyDTO)));
    }

    @Override
    public void deleteFaculty(String id) {
        this.facultyRepository.delete(this.facultyRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Faculty not found with Provided ID: " + id)));
    }

    @Override
    public List<FacultyDTO> getFacultyByName(String name) {
        return Optional.ofNullable(this.facultyRepository.findByName(name))
                .orElse(Collections.emptyList())
                .stream().map(FacultyMapper::FacultyToFacultyDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<FacultyDTO> getFacultyByBranch(Branch branch) {
        return Optional.ofNullable(this.facultyRepository.findFacultiesByBranch(
                        this.branchRepository.findById(branch.getBranch_id())
                                .orElseThrow(()-> new ResourceNotFoundException("Branch not found"))))
                .orElse(Collections.emptyList())
                .stream()
                .map(FacultyMapper::FacultyToFacultyDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<FacultyDTO> getFacultyByCourse(CourseDTO courseDTO) {
        return Optional.ofNullable(this.facultyRepository.findFacultiesByCourseListIsContaining(
                        this.courseRepository.findById(courseDTO.getCourse_id())
                                .orElseThrow(()-> new ResourceNotFoundException("Course not found"))))
                .orElse(Collections.emptyList())
                .stream().map(FacultyMapper::FacultyToFacultyDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FacultyDTO addCourseToFaculty(String faculty_id, List<CourseDTO> courses) throws BadCredentialsException {
        if (courses.isEmpty()){
            throw new BadCredentialsException("Course List is Empty");
        }
        Faculty temp = this.facultyRepository.findById(faculty_id)
                .orElseThrow(()-> new ResourceNotFoundException("Faculty not found"));
        temp.setCourseList(courses.stream()
                .map(CourseMapper::CourseDTOTOCourse)
                .collect(Collectors.toList()));
        return FacultyMapper.FacultyToFacultyDTO(this.facultyRepository.save(temp));
    }
}
