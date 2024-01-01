package com.lms.Controllers;

import com.lms.Entities.Branch;
import com.lms.Services.Service.BranchService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branch")
public class BranchController {

    private final BranchService branchService;

    @Autowired
    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @PostMapping("/add")
    public ResponseEntity<Branch> addBranch(@Valid @RequestBody Branch branch){
        return ResponseEntity.ok(branchService.addBranch(branch));
    }

    @DeleteMapping("/{branchId}/delete")
    public ResponseEntity<Void> deleteBranch(@PathVariable String branchId) throws RuntimeException{
        branchService.deleteBranch(branchId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{branchId}/update")
    public ResponseEntity<Branch> updateBranch(@PathVariable String branchId, @Valid @RequestBody Branch branch) throws Exception{
        return ResponseEntity.ok(branchService.updateBranch(branchId, branch));
    }

    @GetMapping("/get/{branchId}")
    public ResponseEntity<Branch> getBranch(@PathVariable String branchId){
        return ResponseEntity.ok(branchService.getBranch(branchId));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Branch>> getAllBranches(){
        return ResponseEntity.ok(branchService.getAllBranches());
    }
}
