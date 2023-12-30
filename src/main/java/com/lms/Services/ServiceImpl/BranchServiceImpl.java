package com.lms.Services.ServiceImpl;

import com.lms.DTOs.FacultyDTO;
import com.lms.DTOs.StudentDTO;
import com.lms.Entities.Branch;
import com.lms.Exception.ResourceNotFoundException;
import com.lms.Helper.ModelMappers;
import com.lms.Repositories.BranchRepository;
import com.lms.Repositories.FacultyRepository;
import com.lms.Repositories.StudentRepository;
import com.lms.Services.Service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    private final StudentRepository studentRepository;
    private final FacultyRepository facultyRepository;

    @Autowired
    public BranchServiceImpl(BranchRepository branchRepository, StudentRepository studentRepository, FacultyRepository facultyRepository) {
        this.branchRepository = branchRepository;
        this.studentRepository = studentRepository;
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Branch addBranch(Branch branch) throws NullPointerException{
        branch.setBranch_id(UUID.randomUUID().toString());
        return branchRepository.save(branch);
    }

    @Override
    public void deleteBranch(String id) throws ResourceNotFoundException {
        this.branchRepository.delete(this.branchRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Branch not found with Provided ID: " + id)));
    }

    @Override
    public Branch updateBranch(String id, Branch branch) throws ResourceNotFoundException {
        this.branchRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Branch not found with Provided ID: " + id));
        return this.branchRepository.save(Branch.builder().branch_id(id).name(branch.getName()).build());
    }

    @Override
    public Branch getBranch(String id) {
        return this.branchRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Branch not found with Provided ID: " + id));
    }

    @Override
    public List<Branch> getAllBranches() {
        return this.branchRepository.findAll();
    }

    @Override
    public Branch getBranchByName(String name) {
        return this.branchRepository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("Branch not found with Provided Name: " + name));
    }

    public List<StudentDTO> getAllStudentByBranch(Branch branch) {
        return Optional.ofNullable(this.studentRepository.findByBranch(this.branchRepository.findById(branch.getBranch_id())
                        .orElseThrow(()-> new ResourceNotFoundException("Branch Not Found"))))
                .orElse(Collections.emptyList())
                .stream().map(student -> ModelMappers.StudentToStudentDTO(student))
                .collect(Collectors.toList());
    }

    @Override
    public List<FacultyDTO> getAllFacultyByBranch(Branch branch) {
        return Optional.ofNullable(this.facultyRepository.findFacultiesByBranch(
                        this.branchRepository.findById(branch.getBranch_id())
                                .orElseThrow(()-> new ResourceNotFoundException("Branch not found"))))
                .orElse(Collections.emptyList())
                .stream()
                .map(faculty -> ModelMappers.FacultyToFacultyDTO(faculty))
                .collect(Collectors.toList());
    }
}
