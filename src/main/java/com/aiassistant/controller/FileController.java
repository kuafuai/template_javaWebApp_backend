package com.aiassistant.controller;

import com.aiassistant.service.FileService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {
    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public ResultModel uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            return fileService.saveFile(file);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to upload file", e);
        }
    }
}
