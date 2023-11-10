package com.aiassistant.service;

import com.aiassistant.mapper.DemoMapper;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DemoService {
    private final DemoMapper demoMapper;

    @Autowired
    public DemoService(DemoMapper demoMapper) {
        this.demoMapper = demoMapper;
    }

    public ResultModel<String> uploadZipFile(MultipartFile file) {
        String filePath = saveFile(file);
        demoMapper.uploadZipFile(filePath);
        return ResultModel.ofSuccess(filePath);
    }

    private String saveFile(MultipartFile file) {
        // Save the file to the server and return the file path
        return "path/to/zip/file";
    }
}
