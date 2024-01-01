package com.lms.Services.ServiceImpl;

import com.lms.Entities.Branch;
import com.lms.Exception.ResourceNotFoundException;
import com.lms.Repositories.BranchRepository;
import com.lms.Services.Service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;

    @Autowired
    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
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
}
