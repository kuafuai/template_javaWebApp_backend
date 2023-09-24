package com.aiassistant.service;

import com.aiassistant.model.Allocation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AllocationService {
    boolean allocateAsset(String employeeId, String assetId);
    List<Allocation> getAllocationsByEmployeeId(String employeeId);
}

public class AllocationServiceImpl implements AllocationService {
    private Map<String, List<Allocation>> allocationsByEmployeeId;

    public AllocationServiceImpl() {
        allocationsByEmployeeId = new HashMap<>();
    }

    @Override
    public boolean allocateAsset(String employeeId, String assetId) {
        Allocation allocation = new Allocation(employeeId, assetId);
        if (allocationsByEmployeeId.containsKey(employeeId)) {
            List<Allocation> allocations = allocationsByEmployeeId.get(employeeId);
            allocations.add(allocation);
        } else {
            List<Allocation> allocations = new ArrayList<>();
            allocations.add(allocation);
            allocationsByEmployeeId.put(employeeId, allocations);
        }
        return true;
    }

    @Override
    public List<Allocation> getAllocationsByEmployeeId(String employeeId) {
        if (allocationsByEmployeeId.containsKey(employeeId)) {
            return allocationsByEmployeeId.get(employeeId);
        } else {
            return new ArrayList<>();
        }
    }
}