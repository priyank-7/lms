package com.lms.Services.Service;

import com.lms.DTOs.BranchDTO;
import com.lms.Entities.Branch;
import com.lms.Exception.ResourceNotFoundException;

import java.util.List;

public interface BranchService {

    BranchDTO addBranch(Branch branch);

    void deleteBranch(String id) throws ResourceNotFoundException;

    BranchDTO updateBranch(String id, Branch branch) throws ResourceNotFoundException;

    BranchDTO getBranch(String id);

    List<BranchDTO> getAllBranches();

    BranchDTO getBranchByName(String name);
}
