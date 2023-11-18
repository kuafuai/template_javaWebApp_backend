package com.aiassistant.service;

import com.aiassistant.mapper.DepartmentMapper;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentMapper departmentMapper;

    @Autowired
    public DepartmentService(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    public ResultModel<List<String>> getDepartmentList() {
        List<String> departmentList = departmentMapper.getDepartmentList();
        return ResultModel.ofSuccess(departmentList);
    }
}
