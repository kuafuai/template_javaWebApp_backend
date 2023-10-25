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
    public ResultModel<Long> addCable(Cable cable) {
        cableMapper.insertCable(cable);
        return new ResultModel<>(cable.getId());
    }

    @Override
    public ResultPageModel<Cable> getCableList() {
        return new ResultPageModel<>(cableMapper.getCableList());
    }

    @Override
    public ResultModel<Cable> getCableById(Long id) {
        Cable cable = cableMapper.selectById(id);
        if (cable != null) {
            return new ResultModel<>(cable);
        } else {
            return new ResultModel<>("Cable not found");
        }
    }

    @Override
    public ResultModel<Cable> updateCable(Long id, Cable cable) {
        Cable existingCable = cableMapper.selectById(id);
        if (existingCable != null) {
            cable.setId(id);
            cableMapper.updateCable(cable);
            return new ResultModel<>(cable);
        } else {
            return new ResultModel<>("Cable not found");
        }
    }

    @Override
    public ResultModel<String> deleteCable(Long id) {
        Cable existingCable = cableMapper.selectById(id);
        if (existingCable != null) {
            cableMapper.deleteCable(id);
            return new ResultModel<>("Cable deleted successfully");
        } else {
            return new ResultModel<>("Cable not found");
        }
    }
}
