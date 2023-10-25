package com.aiassistant.service.impl;

import com.aiassistant.mapper.CableMapper;
import com.aiassistant.model.Cable;
import com.aiassistant.service.CableService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CableServiceImpl implements CableService {

    private final CableMapper cableMapper;

    @Autowired
    public CableServiceImpl(CableMapper cableMapper) {
        this.cableMapper = cableMapper;
    }

    @Override
    public ResultModel addCable(Cable cable) {
        cableMapper.insertCable(cable);
        return ResultModel.ofSuccess(cable);
    }

    @Override
    public ResultPageModel<Cable> getCableList() {
        return ResultPageModel.of(cableMapper.getCableList());
    }

    @Override
    public ResultModel<Cable> getCableById(Integer id) {
        Cable cable = cableMapper.selectById(id);
        if (cable != null) {
            return ResultModel.ofSuccess(cable);
        } else {
            return ResultModel.ofError("Cable not found");
        }
    }

}
