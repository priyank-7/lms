package com.lms.Services.Service;

import com.lms.Entities.Branch;
import com.lms.Exception.BadCredentialsException;
import com.lms.Exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface BranchService {

        Branch addBranch(Branch branch);

        void deleteBranch(String id) throws ResourceNotFoundException;

        Branch updateBranch(String id, Branch branch) throws BadCredentialsException;

        Branch getBranch(String id);

        List<Branch> getAllBranches();

        Branch getBranchByName(String name);
}
