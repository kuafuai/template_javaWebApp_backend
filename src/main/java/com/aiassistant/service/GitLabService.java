package com.aiassistant.service;

import com.aiassistant.model.FailedBuild;
import com.aiassistant.utils.ResultModel;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GitLabService {
    private static final String GITLAB_API_URL = "https://gitlab.example.com/api/v4";
    private static final String GITLAB_PROJECTS_ENDPOINT = "/projects";
    private static final String GITLAB_JOBS_ENDPOINT = "/jobs";

    public ResultModel<List<FailedBuild>> getFailedBuilds() {
        OkHttpClient client = new OkHttpClient();

        // Get all projects from GitLab
        List<String> projectIds = getAllProjectIds(client);

        // Get failed builds for each project
        List<FailedBuild> failedBuilds = new ArrayList<>();
        for (String projectId : projectIds) {
            List<FailedBuild> projectFailedBuilds = getFailedBuildsForProject(client, projectId);
            failedBuilds.addAll(projectFailedBuilds);
        }

        return ResultModel.ofSuccess(failedBuilds);
    }

    private List<String> getAllProjectIds(OkHttpClient client) {
        List<String> projectIds = new ArrayList<>();

        String url = GITLAB_API_URL + GITLAB_PROJECTS_ENDPOINT;
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                // Parse the response body to get the project IDs
                // ...

                // Add the project IDs to the list
                // ...
            } else {
                return ResultModel.ofError("Failed to get projects from GitLab");
            }
        } catch (IOException e) {
            return ResultModel.ofError("Failed to get projects from GitLab", e);
        }

        return projectIds;
    }

    private List<FailedBuild> getFailedBuildsForProject(OkHttpClient client, String projectId) {
        List<FailedBuild> failedBuilds = new ArrayList<>();

        String url = GITLAB_API_URL + GITLAB_PROJECTS_ENDPOINT + "/" + projectId + GITLAB_JOBS_ENDPOINT;
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                // Parse the response body to get the failed builds
                // ...

                // Add the failed builds to the list
                // ...
            } else {
                return ResultModel.ofError("Failed to get failed builds for project: " + projectId);
            }
        } catch (IOException e) {
            return ResultModel.ofError("Failed to get failed builds for project: " + projectId, e);
        }

        return failedBuilds;
    }
}
