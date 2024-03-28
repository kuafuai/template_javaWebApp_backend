package com.aiassistant.service.impl;

import com.aiassistant.model.FailedBuild;
import com.aiassistant.service.GitLabService;
import com.aiassistant.utils.ResultModel;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GitLabServiceImpl implements GitLabService {

    private static final String GITLAB_API_URL = "https://gitlab.example.com/api/v4";
    private static final String GITLAB_PROJECTS_ENDPOINT = "/projects";
    private static final String GITLAB_JOBS_ENDPOINT = "/jobs";

    private final OkHttpClient httpClient;

    @Autowired
    public GitLabServiceImpl(OkHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public ResultModel<List<FailedBuild>> getFailedBuilds() {
        List<FailedBuild> failedBuilds = new ArrayList<>();

        try {
            // Get all projects from GitLab API
            String projectsUrl = GITLAB_API_URL + GITLAB_PROJECTS_ENDPOINT;
            Request projectsRequest = new Request.Builder()
                    .url(projectsUrl)
                    .build();
            Response projectsResponse = httpClient.newCall(projectsRequest).execute();
            if (!projectsResponse.isSuccessful()) {
                return ResultModel.ofError("Failed to get projects from GitLab API");
            }
            String projectsResponseBody = projectsResponse.body().string();

            // Get failed jobs for each project
            for (String project : projectsResponseBody.split(",")) {
                String projectId = project.split(":")[1];
                String jobsUrl = GITLAB_API_URL + GITLAB_PROJECTS_ENDPOINT + "/" + projectId + GITLAB_JOBS_ENDPOINT;
                Request jobsRequest = new Request.Builder()
                        .url(jobsUrl)
                        .build();
                Response jobsResponse = httpClient.newCall(jobsRequest).execute();
                if (!jobsResponse.isSuccessful()) {
                    return ResultModel.ofError("Failed to get jobs for project " + projectId);
                }
                String jobsResponseBody = jobsResponse.body().string();

                // Parse failed jobs
                for (String job : jobsResponseBody.split(",")) {
                    String jobId = job.split(":")[1];
                    String jobUrl = GITLAB_API_URL + GITLAB_PROJECTS_ENDPOINT + "/" + projectId + GITLAB_JOBS_ENDPOINT + "/" + jobId;
                    Request jobRequest = new Request.Builder()
                            .url(jobUrl)
                            .build();
                    Response jobResponse = httpClient.newCall(jobRequest).execute();
                    if (!jobResponse.isSuccessful()) {
                        return ResultModel.ofError("Failed to get job " + jobId + " for project " + projectId);
                    }
                    String jobResponseBody = jobResponse.body().string();

                    // Check if job is failed
                    if (jobResponseBody.contains("\"status\":\"failed\"")) {
                        FailedBuild failedBuild = new FailedBuild();
                        failedBuild.setId(Integer.parseInt(jobId));
                        failedBuild.setProjectName(project);
                        failedBuild.setReason("Failed job");
                        failedBuilds.add(failedBuild);
                    }
                }
            }

            return ResultModel.ofSuccess(failedBuilds);
        } catch (IOException e) {
            return ResultModel.ofError("An error occurred while getting failed builds", e);
        }
    }
}
