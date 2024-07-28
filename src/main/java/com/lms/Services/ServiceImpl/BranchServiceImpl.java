package com.lms.Services.ServiceImpl;

import com.github.f4b6a3.ulid.UlidCreator;
import com.lms.DTOs.BranchDTO;
import com.lms.Entities.Branch;
import com.lms.Exception.ResourceNotFoundException;
import com.lms.Helper.ModelMappers.BranchMapper;
import com.lms.Repositories.BranchRepository;
import com.lms.Services.Service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;

    @Autowired
    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public BranchDTO addBranch(Branch branch) throws NullPointerException{
        branch.setBranch_id(UlidCreator.getUlid().toString());
        return BranchMapper.BranchToBranchDTO(branchRepository.save(branch));
    }

    @Override
    public void deleteBranch(String id) throws ResourceNotFoundException {
        this.branchRepository.delete(this.branchRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Branch not found with Provided ID: " + id)));
    }

    @Override
    public BranchDTO updateBranch(String id, Branch branch) throws ResourceNotFoundException {
        this.branchRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Branch not found with Provided ID: " + id));
        return BranchMapper.BranchToBranchDTO(this.branchRepository.save(Branch.builder().branch_id(id).name(branch.getName()).build()));
    }

    @Override
    public BranchDTO getBranch(String id) {
        return BranchMapper.BranchToBranchDTO(this.branchRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Branch not found with Provided ID: " + id)));
    }

    @Override
    public List<BranchDTO> getAllBranches() {
        return Optional.of(this.branchRepository.findAll())
                .orElseThrow(() -> new ResourceNotFoundException("No Branches Found"))
                .stream().map(BranchMapper::BranchToBranchDTO)
                .toList();
    }

    @Override
    public BranchDTO getBranchByName(String name) {
        return BranchMapper.BranchToBranchDTO(this.branchRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Branch not found with Provided Name: " + name)));
    }
}
