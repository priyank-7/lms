package com.lms.Services.ServiceImpl;

import com.lms.DTOs.CourseDTO;
import com.lms.DTOs.FacultyDTO;
import com.lms.Entities.Branch;
import com.lms.Entities.Faculty;
import com.lms.Exception.BadCredentialsException;
import com.lms.Exception.ResourceNotFoundException;
import com.lms.Helper.ModelMappers;
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
    @Autowired
    public FacultyServiceImpl(FacultyRepository facultyRepository, BranchRepository branchRepository, CourseRepository courseRepository) {
        this.facultyRepository = facultyRepository;
    }
    @Override
    public List<FacultyDTO> getAllFaculties() {
        return this.facultyRepository.findAll().stream().map(faculty -> ModelMappers.FacultyToFacultyDTO(faculty)).collect(Collectors.toList());
    }

    @Override
    public FacultyDTO getFaculty(String id) {
        return ModelMappers.FacultyToFacultyDTO(this.facultyRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Faculty not found")));
    }

    @Override
    public FacultyDTO addFaculty(FacultyDTO facultyDTO) {
        facultyDTO.setFaculty_id(UUID.randomUUID().toString());
        return ModelMappers.FacultyToFacultyDTO(this.facultyRepository.save(ModelMappers.FacultyDTOTOFaculty(facultyDTO)));
    }

    @Override
    public FacultyDTO updateFaculty(String id, FacultyDTO facultyDTO) {
        facultyDTO.setFaculty_id(id);
        return ModelMappers.FacultyToFacultyDTO(
                this.facultyRepository.save(
                        ModelMappers.FacultyDTOTOFaculty(
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
                .stream().map(faculty -> ModelMappers.FacultyToFacultyDTO(faculty))
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
                        .map(courseDTO -> ModelMappers.CourseDTOTOCourse(courseDTO))
                        .collect(Collectors.toList()));
                return ModelMappers.FacultyToFacultyDTO(this.facultyRepository.save(temp));
    }

    @Override
    public FacultyDTO removeCourseFromFaculty(String faculty_id, CourseDTO courseDTO) {
        Faculty temp = this.facultyRepository.findById(faculty_id)
                .orElseThrow(()-> new ResourceNotFoundException("Faculty not found"));
        if(!temp.getCourseList().isEmpty()){
            temp.setCourseList(temp.getCourseList().stream()
                    .filter(course -> !course.getCourse_id().equals(courseDTO.getCourse_id()))
                    .collect(Collectors.toList()));
        }
        return ModelMappers.FacultyToFacultyDTO(this.facultyRepository.save(temp));
    }
}
