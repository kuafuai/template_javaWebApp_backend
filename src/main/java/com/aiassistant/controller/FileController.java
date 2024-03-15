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
        String fileName = file.getOriginalFilename();
        String fileType = file.getContentType();
        long fileSize = file.getSize();

        // Call the fileService to handle file upload and save
        fileService.uploadAndSaveFile(file);

        return ResultModel.ofSuccess("File uploaded successfully", new FileUploadInfo(fileName, fileType, fileSize));
    }

    private static class FileUploadInfo {
        private final String fileName;
        private final String fileType;
        private final long fileSize;

        public FileUploadInfo(String fileName, String fileType, long fileSize) {
            this.fileName = fileName;
            this.fileType = fileType;
            this.fileSize = fileSize;
        }

        public String getFileName() {
            return fileName;
        }

        public String getFileType() {
            return fileType;
        }

        public long getFileSize() {
            return fileSize;
        }
    }
}
