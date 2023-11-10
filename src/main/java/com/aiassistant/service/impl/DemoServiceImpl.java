package com.aiassistant.service.impl;

import com.aiassistant.service.DemoService;
import com.aiassistant.utils.ResultModel;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public ResultModel<String> uploadZipFile(MultipartFile file) {
        try {
            // 获取当前目录
            String currentPath = System.getProperty("user.dir");
            // 保存文件的路径
            String savePath = currentPath + File.separator + file.getOriginalFilename();
            // 将上传的zip文件保存到服务器的当前目录中
            file.transferTo(new File(savePath));
            return ResultModel.ofSuccess(savePath);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultModel.ofError("Failed to upload zip file", e);
        }
    }
}
