package com.aiassistant.model;

import lombok.Data;

import java.util.Date;

@Data
public class File {
    private int id;
    private String fileName;
    private String fileType;
    private long fileSize;
    private String fileUrl;
    private Date createTime;
}
