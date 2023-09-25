package com.aiassistant.model;

public class Attachment {
    private String id;
    private String fileName;
    private long fileSize;
    private String attachmentLink;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Id cannot be null or empty");
        }
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("FileName cannot be null or empty");
        }
        this.fileName = fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        if (fileSize < 0) {
            throw new IllegalArgumentException("FileSize cannot be negative");
        }
        this.fileSize = fileSize;
    }

    public String getAttachmentLink() {
        return attachmentLink;
    }

    public void setAttachmentLink(String attachmentLink) {
        if (attachmentLink == null || attachmentLink.isEmpty()) {
            throw new IllegalArgumentException("AttachmentLink cannot be null or empty");
        }
        this.attachmentLink = attachmentLink;
    }
}