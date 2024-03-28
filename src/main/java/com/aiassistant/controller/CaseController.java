package com.aiassistant.controller;

import com.aiassistant.model.Case;
import com.aiassistant.service.CaseService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/case")
public class CaseController {
    private final CaseService caseService;

    @Autowired
    public CaseController(CaseService caseService) {
        this.caseService = caseService;
    }

    @PostMapping("/add")
    public ResultModel addCase(@RequestBody Case caseInfo) {
        return caseService.addCase(caseInfo);
    }

    @PostMapping("/list")
    public ResultPageModel<Case> getCaseList() {
        return caseService.getCaseList();
    }
}
