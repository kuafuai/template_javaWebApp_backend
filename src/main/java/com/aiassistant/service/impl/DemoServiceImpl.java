package com.aiassistant.service.impl;

import com.aiassistant.mapper.DemoMapper;
import com.aiassistant.model.Demo;
import com.aiassistant.service.DemoService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    private final DemoMapper demoMapper;

    @Autowired
    public DemoServiceImpl(DemoMapper demoMapper) {
        this.demoMapper = demoMapper;
    }

    @Override
    public ResultModel<Demo> addDemo(Demo demo) {
        demoMapper.insertDemo(demo);
        return ResultModel.ofSuccess(demo);
    }

    @Override
    public ResultPageModel<Demo> getDemoList() {
        return ResultPageModel.of(demoMapper.getDemoList());
    }

    @Override
    public Demo getById(Integer id) {
        return demoMapper.selectById(id);
    }

    @Override
    public ResultPageModel<Demo> getDemoListByType(String messageType, Integer pageNo, Integer pageSize) {
        int totalRecords = demoMapper.getDemoListByType(messageType).size();
        int totalPage = (totalRecords + pageSize - 1) / pageSize;
        int firstIndex = (pageNo - 1) * pageSize;
        return ResultPageModel.of(demoMapper.getDemoListByType(messageType, firstIndex, pageSize), totalRecords, pageNo, pageSize, totalPage);
    }
}
