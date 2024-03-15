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

    public ResultModel uploadFile(MultipartFile file) {
        // 校验文件的完整性和合法性
        if (file.isEmpty()) {
            return ResultModel.ofError("File is empty");
        }

        // 保存文件到服务器中
        try {
            // TODO: Save file to server
            // file.transferTo(new File("path/to/save/file"));
        } catch (Exception e) {
            return ResultModel.ofError("Failed to save file", e);
        }

        // 保存文件信息到数据库
        try {
            // TODO: Save file information to database
            // fileMapper.insertFile(file.getOriginalFilename(), file.getSize());
        } catch (Exception e) {
            return ResultModel.ofError("Failed to save file information to database", e);
        }

        return ResultModel.ofSuccess();
    }
}
