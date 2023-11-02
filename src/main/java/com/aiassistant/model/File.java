package com.aiassistant.model;

import lombok.Data;

@Data
public class File {
    private int id;
    private String fileName;
    private String fileType;
    private long fileSize;
}
