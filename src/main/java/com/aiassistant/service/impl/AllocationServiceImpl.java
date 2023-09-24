package com.aiassistant.service.impl;

import com.aiassistant.mapper.AllocationMapper;
import com.aiassistant.mapper.EmployeeMapper;
import com.aiassistant.model.Allocation;
import com.aiassistant.service.AllocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class AllocationServiceImpl implements AllocationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AllocationServiceImpl.class);

    private final AllocationMapper allocationMapper;
    private final EmployeeMapper employeeMapper;

    @Autowired
    public AllocationServiceImpl(AllocationMapper allocationMapper, EmployeeMapper employeeMapper) {
        this.allocationMapper = allocationMapper;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public boolean allocateAsset(String employeeId, String assetId) {
        // Check if employeeId is null or empty
        if (StringUtils.isEmpty(employeeId)) {
            LOGGER.error("Employee ID is null or empty");
            throw new IllegalArgumentException("Employee ID is required");
        }

        // Check if assetId is null or empty
        if (StringUtils.isEmpty(assetId)) {
            LOGGER.error("Asset ID is null or empty");
            throw new IllegalArgumentException("Asset ID is required");
        }

        // Check if employee exists
        if (employeeMapper.selectEmployeeById(employeeId) == null) {
            LOGGER.error("Employee not found with ID: {}", employeeId);
            return false;
        }

        // Check if asset is already allocated
        if (allocationMapper.selectAllocationByAssetId(assetId) != null) {
            LOGGER.error("Asset already allocated with ID: {}", assetId);
            return false;
        }

        // Create new allocation
        Allocation allocation = new Allocation();
        allocation.setEmployeeId(employeeId);
        allocation.setAssetId(assetId);

        // Insert allocation into database
        allocationMapper.insertAllocation(allocation);

        LOGGER.info("Asset allocated successfully with ID: {}", assetId);
        return true;
    }

    @Override
    public List<Allocation> getAllocationsByEmployeeId(String employeeId) {
        // Check if employeeId is null or empty
        if (StringUtils.isEmpty(employeeId)) {
            LOGGER.error("Employee ID is null or empty");
            throw new IllegalArgumentException("Employee ID is required");
        }

        return allocationMapper.selectAllocationsByEmployeeId(employeeId);
    }
}