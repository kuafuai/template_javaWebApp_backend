package com.aiassistant.service;

import com.aiassistant.mapper.AttachmentMapper;
import com.aiassistant.model.Attachment;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
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

    public ResultModel<Attachment> addAttachment(MultipartFile file) {
        // TODO: Implement this method
        return null;
    }

    public ResultModel<Attachment> getAttachmentById(Integer id) {
        // TODO: Implement this method
        return null;
    }

    public ResultPageModel<Attachment> getAllAttachments() {
        // TODO: Implement this method
        return null;
    }

    public ResultModel<Attachment> updateAttachment(Integer id, MultipartFile file) {
        // TODO: Implement this method
        return null;
    }

    public ResultModel<Attachment> deleteAttachment(Integer id) {
        // TODO: Implement this method
        return null;
    }
}
