package com.aiassistant.mapper;

import com.aiassistant.model.Allocation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AllocationMapper {
    @Insert("INSERT INTO allocation (allocation_id, employee_id, asset_id, allocation_date) " +
            "VALUES (#{allocationId}, #{employeeId}, #{assetId}, #{allocationDate})")
    int insertAllocation(Allocation allocation);

    @Select("SELECT * FROM allocation WHERE employee_id = #{employeeId}")
    List<Allocation> selectAllocationsByEmployeeId(@Param("employeeId") String employeeId);
}

// Add error handling for database operations
package com.aiassistant.mapper;

import com.aiassistant.model.Allocation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AllocationMapper {
    @Insert("INSERT INTO allocation (allocation_id, employee_id, asset_id, allocation_date) " +
            "VALUES (#{allocationId}, #{employeeId}, #{assetId}, #{allocationDate})")
    int insertAllocation(Allocation allocation) throws Exception;

    @Select("SELECT * FROM allocation WHERE employee_id = #{employeeId}")
    List<Allocation> selectAllocationsByEmployeeId(@Param("employeeId") String employeeId) throws Exception;
}

// Add documentation to the methods in the AllocationMapper interface
package com.aiassistant.mapper;

import com.aiassistant.model.Allocation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AllocationMapper {
    /**
     * Inserts a new allocation into the database.
     *
     * @param allocation The allocation to be inserted.
     * @return The number of rows affected by the insertion.
     * @throws Exception If an error occurs during the insertion.
     */
    @Insert("INSERT INTO allocation (allocation_id, employee_id, asset_id, allocation_date) " +
            "VALUES (#{allocationId}, #{employeeId}, #{assetId}, #{allocationDate})")
    int insertAllocation(Allocation allocation) throws Exception;

    /**
     * Retrieves a list of allocations for a given employee ID.
     *
     * @param employeeId The ID of the employee.
     * @return A list of allocations for the employee.
     * @throws Exception If an error occurs during the selection.
     */
    @Select("SELECT * FROM allocation WHERE employee_id = #{employeeId}")
    List<Allocation> selectAllocationsByEmployeeId(@Param("employeeId") String employeeId) throws Exception;
}