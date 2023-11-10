package com.aiassistant.model;

public class Demo {
    private String filePath;

    public void uploadZipFile(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
