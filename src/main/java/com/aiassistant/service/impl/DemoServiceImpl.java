package com.aiassistant.service.impl;

import com.aiassistant.mapper.DemoMapper;
import com.aiassistant.model.Demo;
import com.aiassistant.service.DemoService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务逻辑层--DemoService接口实现
 */
@Service
@RequiredArgsConstructor
public class DemoServiceImpl implements DemoService {

    private final DemoMapper demoMapper;

    @Override
    public ResultModel<Demo> addDemo(Demo demo) {
        // 生成唯一的资产编号
        String assetNumber = generateAssetNumber();
        demo.setAssetNumber(assetNumber);

        // 将资产信息保存到数据库
        Demo result = demoMapper.insertDemo(demo);

        return ResultModel.ofSuccess(result);
    }

    @Override
    public ResultPageModel<Demo> getDemoList() {
        List<Demo> list = demoMapper.getDemoList();

        return ResultPageModel.of(list);
    }

    @Override
    public Demo getById(Integer id) {
        return demoMapper.selectById(id);
    }

    private String generateAssetNumber() {
        // 生成唯一的资产编号的逻辑
        // ...
        return "ASSET123456";
    }
}