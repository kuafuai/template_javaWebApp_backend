package com.aiassistant.service.impl;

import com.aiassistant.mapper.AttachmentMapper;
import com.aiassistant.model.Attachment;
import com.aiassistant.service.AttachmentService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentMapper attachmentMapper;

    @Autowired
    public AttachmentServiceImpl(AttachmentMapper attachmentMapper) {
        this.attachmentMapper = attachmentMapper;
    }

    @Override
    public ResultModel<Attachment> addAttachment(MultipartFile file, Integer fileType) {
        // TODO: Implement addAttachment method
        return null;
    }

    @Override
    public ResultModel deleteAttachment(Integer attachmentId) {
        // TODO: Implement deleteAttachment method
        return null;
    }

    @Override
    public ResultModel updateAttachment(Integer attachmentId, MultipartFile file, Integer fileType) {
        // TODO: Implement updateAttachment method
        return null;
    }

    @Override
    public ResultModel<Attachment> getAttachmentById(Integer attachmentId) {
        // TODO: Implement getAttachmentById method
        return null;
    }
}
