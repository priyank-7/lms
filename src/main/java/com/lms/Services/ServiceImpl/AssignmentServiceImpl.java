package com.lms.Services.ServiceImpl;

import com.lms.DTOs.AssignmentDTO;
import com.lms.DTOs.CourseDTO;
import com.lms.Entities.Assignment;
import com.lms.Entities.Course;
import com.lms.Exception.ResourceNotFoundException;
import com.lms.Helper.ModelMapper;
import com.lms.Repositories.AssignmentRepository;
import com.lms.Repositories.CourseRepository;
import com.lms.Services.Service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public AssignmentServiceImpl(AssignmentRepository assignmentRepository, CourseServiceImpl courseService, CourseRepository courseRepository) {
        this.assignmentRepository = assignmentRepository;
        this.courseRepository = courseRepository;
    }


    @Override
    public AssignmentDTO addAssignment(AssignmentDTO assignmentDTO) {
        assignmentDTO.setAssignment_id(UUID.randomUUID().toString());
        assignmentDTO.setAssign_date(new Date());
        return ModelMapper.AssignmentToAssignmentDTO(this.assignmentRepository.save(
                ModelMapper.AssignmentDTOTOAssignment(assignmentDTO)));
    }

    @Override
    public AssignmentDTO updateAssignment(String assignment_id, AssignmentDTO assignmentDTO) {
        Assignment temp_assignment = this.assignmentRepository.findById(assignment_id)
                .orElseThrow(()-> new ResourceNotFoundException("Assignment not found"));
        return ModelMapper.AssignmentToAssignmentDTO(this.assignmentRepository
                .save(ModelMapper.AssignmentDTOTOAssignment(temp_assignment, assignmentDTO)));
    }

    @Override
    public AssignmentDTO getAssignmentById(String id) {
        return ModelMapper.AssignmentToAssignmentDTO(this.assignmentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Assignment not found")));
    }

    @Override
    public void deleteAssignment(String id) {
        this.assignmentRepository.delete(
                this.assignmentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Assignment not found")));

    }

    @Override
    public List<AssignmentDTO> getAllAssignments() {
        return Optional.of(this.assignmentRepository.findAll())
                .orElse(Collections.emptyList())
                .stream()
                .map(ModelMapper::AssignmentToAssignmentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AssignmentDTO> getAssignmentsByCourse(Course course) {
        return Optional.of(this.assignmentRepository.findByCourse(course))
                .orElse(Collections.emptyList())
                .stream()
                .map(ModelMapper::AssignmentToAssignmentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AssignmentDTO> getAssignmentsByCourseAssignDateGreaterThen(CourseDTO course , String courseId) {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR , date.getYear());
        c.set(Calendar.MONTH , 1);
        c.set(Calendar.DAY_OF_MONTH , 1);
        return Optional.of(this.assignmentRepository.findByCourse(
                this.courseRepository.findById(courseId)
                        .orElseThrow(() -> new ResourceNotFoundException("Course Not Found"))))
                .orElse(Collections.emptyList())
                .stream()
                .map(ModelMapper::AssignmentToAssignmentDTO)
                .collect(Collectors.toList());
    }
}
