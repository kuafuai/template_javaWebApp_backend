package com.aiassistant.service;

import com.aiassistant.model.Case;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;

public interface CaseService {
    ResultModel<Case> addCase(Case caseObj);

    ResultPageModel<Case> getCaseList();

    Case getById(Integer id);
}
