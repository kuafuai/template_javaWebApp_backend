package com.aiassistant.model;

import lombok.Data;

import java.util.Date;

@Data
public class Attachment {
    private String id;
    private String fileName;
    private Long fileSize;
    private Date createTime;
    private String filePath;

    public Attachment(String id, String fileName, Long fileSize, Date createTime, String filePath) {
        this.id = id;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.createTime = createTime;
        this.filePath = filePath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
