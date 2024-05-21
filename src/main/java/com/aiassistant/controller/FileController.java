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
    public ResultModel<String> uploadZipFile(@RequestParam("file") MultipartFile file) {
        // Call the fileService to handle the uploaded ZIP file
        return fileService.uploadZipFile(file);
    }
}
