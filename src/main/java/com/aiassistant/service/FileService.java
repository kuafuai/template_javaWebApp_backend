package com.aiassistant.service;

import com.aiassistant.mapper.FileMapper;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
    private final FileMapper fileMapper;

    @Autowired
    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    public ResultModel saveFile(MultipartFile file) {
        // Save file logic here
        // ...
        return ResultModel.ofSuccess();
    }
}
