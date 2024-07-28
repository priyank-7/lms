package com.lms.Helper.ModelMappers;

import com.lms.DTOs.BranchDTO;
import com.lms.Entities.Branch;

public class BranchMapper {

    public static BranchDTO BranchToBranchDTO(Branch branch){
        return BranchDTO.builder()
                .branch_id(branch.getBranch_id())
                .name(branch.getName())
                .build();
    }
}
