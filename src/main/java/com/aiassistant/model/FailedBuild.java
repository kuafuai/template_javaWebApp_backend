package com.aiassistant.model;

public class FailedBuild {
    private int id;
    private String projectName;
    private String reason;

    public FailedBuild() {
    }

    public FailedBuild(int id, String projectName, String reason) {
        this.id = id;
        this.projectName = projectName;
        this.reason = reason;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
