package com.lms.Services.ServiceImpl;

import com.github.f4b6a3.ulid.UlidCreator;
import com.lms.DTOs.AssignmentResultDTO;
import com.lms.Entities.Assignment;
import com.lms.Entities.Assignment_Result;
import com.lms.Entities.Student;
import com.lms.Exception.ResourceNotFoundException;
import com.lms.Helper.DateTime.DateTimeUtilities;
import com.lms.Helper.ModelMappers.AssignmentResultMapper;
import com.lms.Repositories.AssignmentRepository;
import com.lms.Repositories.AssignmentResultRepository;
import com.lms.Repositories.StudentRepository;
import com.lms.Services.Service.AssignmentResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.lms.Helper.ModelMappers.AssignmentResultMapper.AssignmentResultToAssignmentResultDTO;

@Service
public class AssignmentResultServiceImpl implements AssignmentResultService {

    private final AssignmentResultRepository assignmentResultRepository;
    private final StudentRepository studentRepository;
    private final AssignmentRepository assignmentRepository;

    @Autowired
    public AssignmentResultServiceImpl(AssignmentResultRepository assignmentResultRepository, StudentRepository studentRepository, AssignmentRepository assignmentRepository) {
        this.assignmentResultRepository = assignmentResultRepository;
        this.assignmentRepository = assignmentRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<AssignmentResultDTO> getAssignmentResultByStudent(String studentId) {
        return Optional.ofNullable(this.assignmentResultRepository.findByStudentAndPostedOnAfter(
                this.studentRepository.findById(studentId)
                        .orElseThrow(()-> new ResourceNotFoundException("Student not found")),
                DateTimeUtilities.firstDayOfYear()))
                .orElse(Collections.emptyList())
                .stream().map(AssignmentResultMapper::AssignmentResultToAssignmentResultDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AssignmentResultDTO addAssignmentResult(AssignmentResultDTO assignmentResultDTO, String student_id, String assignment_id) {
        assignmentResultDTO.setAssignmentResult_id(UlidCreator.getUlid().toString());
        assignmentResultDTO.setPostedOn(new Date());

        Student tempStudent = this.studentRepository.findById(student_id)
                .orElseThrow(()-> new ResourceNotFoundException("Student not found"));
        Assignment tempAssignment = this.assignmentRepository.findById(assignment_id)
                .orElseThrow(()-> new ResourceNotFoundException("Assignment not found"));
        return AssignmentResultMapper.AssignmentResultToAssignmentResultDTO(
                this.assignmentResultRepository.save(
                        AssignmentResultMapper.AssignmentResultDTOToAssignmentResult(assignmentResultDTO, tempStudent, tempAssignment)));
    }

    @Override
    public AssignmentResultDTO updateAssignmentResult(AssignmentResultDTO assignmentResultDTO, String assignmentId) {
        Assignment_Result temp = this.assignmentResultRepository.findById(assignmentId)
                .orElseThrow(()-> new ResourceNotFoundException("Assignment Result not found"));
        return AssignmentResultMapper.AssignmentResultToAssignmentResultDTO(this.assignmentResultRepository.save(
                AssignmentResultMapper.updateAssignmentResultFromDTO(temp, assignmentResultDTO)));
    }

    @Override
    public void deleteAssignmentResult(String assignmentId) {
        this.assignmentResultRepository.delete(this.assignmentResultRepository.findById(assignmentId)
                .orElseThrow(()-> new ResourceNotFoundException("Assignment Result not found")));
    }

    @Override
    public AssignmentResultDTO getAssignmentResultByAssignmentAndStudent(String studentId, String assignmentId) {
        return AssignmentResultToAssignmentResultDTO(this.assignmentResultRepository.findByAssignmentAndStudentAndPostedOnAfter(
                this.assignmentRepository.findById(assignmentId)
                        .orElseThrow(()-> new ResourceNotFoundException("assignment not found")),
                this.studentRepository.findById(studentId)
                        .orElseThrow(()-> new ResourceNotFoundException("Student not found")),
                DateTimeUtilities.firstDayOfYear())
                .orElseThrow(()-> new ResourceNotFoundException("Assignment Result not found")));
    }

    @Override
    public List<AssignmentResultDTO> getAssignmentResultByAssignment(String assignment_id) {
        return Optional.ofNullable(this.assignmentResultRepository.findByAssignment(
                this.assignmentRepository.findById(assignment_id)
                        .orElseThrow(()-> new ResourceNotFoundException("Assignment not found"))))
                .orElse(Collections.emptyList())
                .stream().map(AssignmentResultMapper::AssignmentResultToAssignmentResultDTO)
                .collect(Collectors.toList());
    }
}
