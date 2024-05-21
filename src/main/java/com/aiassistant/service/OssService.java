package com.aiassistant.service;

import com.aiassistant.utils.ResultModel;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class OssService {
    @Value("${oss.endpoint}")
    private String endpoint;

    @Value("${oss.accessKeyId}")
    private String accessKeyId;

    @Value("${oss.accessKeySecret}")
    private String accessKeySecret;

    @Value("${oss.bucketName}")
    private String bucketName;

    public ResultModel<String> uploadFile(File file, String ossDir) {
        try {
            // 创建OSSClient实例
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            // 上传文件到指定的OSS目录
            String objectName = ossDir + "/" + file.getName();
            ossClient.putObject(bucketName, objectName, file);

            // 关闭OSSClient
            ossClient.shutdown();

            // 返回上传成功的文件路径
            String fileUrl = "https://" + bucketName + "." + endpoint + "/" + objectName;
            return ResultModel.ofSuccess(fileUrl);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultModel.ofError("Failed to upload file", e);
        }
    }
}
