package com.aiassistant.model;

import lombok.Data;

@Data
public class Attachment {
    private Integer attachmentId;
    private String fileName;
    private Long fileSize;
    private String filePath;
    private String uploadTime;
}
