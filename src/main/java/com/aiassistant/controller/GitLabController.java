package com.aiassistant.controller;

import com.aiassistant.model.FailedBuild;
import com.aiassistant.service.impl.GitLabServiceImpl;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gitlab")
public class GitLabController {
    private final GitLabServiceImpl gitLabService;

    @Autowired
    public GitLabController(GitLabServiceImpl gitLabService) {
        this.gitLabService = gitLabService;
    }

    @GetMapping("/failed-builds")
    public ResultModel<List<FailedBuild>> getFailedBuilds() {
        return gitLabService.getFailedBuilds();
    }
}
