package com.aiassistant.service;

import com.aiassistant.mapper.FileMapper;
import com.aiassistant.model.File;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@Service
public class FileService {
    private final FileMapper fileMapper;

    @Autowired
    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    public ResultModel saveFile(MultipartFile file) throws IOException {
        // Save file logic here
        // ...
        if (file.isEmpty()) {
            return ResultModel.ofError("请选择文件进行上传。");
        }
        // 获取文件信息
        String fileName = file.getOriginalFilename();
        String fileType = file.getContentType();
        long fileSize = file.getSize();

        // 保存文件到服务器
        String uploadDir = "D:\\project\\html"; // 保存文件的目录
        java.io.File uploadPath = new java.io.File(uploadDir);
        if (!uploadPath.exists()) {
            uploadPath.mkdir();
        }

        java.io.File saveFile = new java.io.File(uploadPath, fileName);
        file.transferTo(saveFile);

        File fileModel = new File();
        fileModel.setFileName(fileName);
        fileModel.setFileType(fileType);
        fileModel.setFileSize(fileSize);
        fileModel.setFileUrl("/custom-resources/" + fileName);
        fileModel.setCreateTime(new Date());

        fileMapper.insertFile(fileModel);

        return ResultModel.ofSuccess(fileModel);
    }
}
