package com.aiassistant.service.impl;

import com.aiassistant.mapper.CaseMapper;
import com.aiassistant.model.Case;
import com.aiassistant.service.CaseService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaseServiceImpl implements CaseService {

    private final CaseMapper caseMapper;

    @Autowired
    public CaseServiceImpl(CaseMapper caseMapper) {
        this.caseMapper = caseMapper;
    }

    @Override
    public ResultModel<Case> addCase(Case case) {
        try {
            caseMapper.insertCase(case);
            return ResultModel.ofSuccess(case);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to add case", e);
        }
    }

    @Override
    public ResultPageModel<Case> getCaseList() {
        try {
            List<Case> caseList = caseMapper.getCaseList();
            return ResultPageModel.of(caseList);
        } catch (Exception e) {
            return ResultPageModel.ofError("Failed to get case list", e);
        }
    }

    @Override
    public Case getById(Integer id) {
        return caseMapper.selectById(id);
    }
}
