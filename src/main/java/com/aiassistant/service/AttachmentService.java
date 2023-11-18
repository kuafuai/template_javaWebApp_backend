package com.aiassistant.service;

import com.aiassistant.mapper.AttachmentMapper;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AttachmentService {
    private final AttachmentMapper attachmentMapper;

    @Autowired
    public AttachmentService(AttachmentMapper attachmentMapper) {
        this.attachmentMapper = attachmentMapper;
    }

    public ResultModel uploadAttachment(MultipartFile file) {
        // Implement the logic to upload the attachment and save it to the database
        // Return the appropriate ResultModel based on the result of the upload operation
    }
}
