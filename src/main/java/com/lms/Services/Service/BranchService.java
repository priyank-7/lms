package com.lms.Services.Service;

import com.lms.Entities.Branch;
import com.lms.Exception.ResourceNotFoundException;

import java.util.List;

public interface BranchService {

    Branch addBranch(Branch branch);

    void deleteBranch(String id) throws ResourceNotFoundException;

    Branch updateBranch(String id, Branch branch) throws ResourceNotFoundException;

    Branch getBranch(String id);

    List<Branch> getAllBranches();

    Branch getBranchByName(String name);
}
