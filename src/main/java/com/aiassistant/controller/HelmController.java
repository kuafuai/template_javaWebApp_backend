package com.aiassistant.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface HelmService {

    void uploadHelmPackage(MultipartFile file) throws IOException;

    // other method declarations
}
