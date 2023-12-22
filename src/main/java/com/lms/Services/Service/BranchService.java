package com.lms.Services.Service;

import com.lms.Entities.Branch;

import java.util.List;

public interface BranchService {

        Branch addBranch(Branch branch);

        void deleteBranch(String id);

        void updateBranch(String id, Branch branch);

        Branch getBranch(String id);

        List<Branch> getAllBranches();

        Branch getBranchByName(String name);
}
