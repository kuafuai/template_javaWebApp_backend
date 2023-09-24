package com.aiassistant.controller;

import com.aiassistant.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllocationController {

    private final AllocationService allocationService;

    @Autowired
    public AllocationController(AllocationService allocationService) {
        this.allocationService = allocationService;
    }

    @PostMapping("/allocate")
    public ResponseEntity<?> allocateAsset(@RequestParam String allocationId, @RequestParam String employeeId) {
        if (allocationId == null || allocationId.isEmpty() || employeeId == null || employeeId.isEmpty()) {
            return ResponseEntity.badRequest().body("Allocation ID and Employee ID are required.");
        }
        
        boolean success = allocationService.allocateAsset(allocationId, employeeId);
        if (success) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body("Failed to allocate asset.");
        }
    }
}