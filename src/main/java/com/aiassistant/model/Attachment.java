package com.aiassistant.model;

public class Attachment {
    private int attachmentId;
    private String attachmentName;
    private String attachmentType;
    private int attachmentSize;
    private String attachmentContent;

    public int getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(int attachmentId) {
        this.attachmentId = attachmentId;
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    public String getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(String attachmentType) {
        this.attachmentType = attachmentType;
    }

    public int getAttachmentSize() {
        return attachmentSize;
    }

    public void setAttachmentSize(int attachmentSize) {
        this.attachmentSize = attachmentSize;
    }

    public String getAttachmentContent() {
        return attachmentContent;
    }

    public void setAttachmentContent(String attachmentContent) {
        this.attachmentContent = attachmentContent;
    }
}
