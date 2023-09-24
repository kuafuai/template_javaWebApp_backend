package com.aiassistant.service.impl;

import com.aiassistant.mapper.AttachmentMapper;
import com.aiassistant.model.Attachment;
import com.aiassistant.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentMapper attachmentMapper;

    @Autowired
    public AttachmentServiceImpl(AttachmentMapper attachmentMapper) {
        this.attachmentMapper = attachmentMapper;
    }

    @Override
    public int addAttachment(Attachment attachment) {
        // Save attachment information to the server
        // and return the attachment id
        return attachmentMapper.insertAttachment(attachment);
    }

    @Override
    public int deleteAttachment(int attachmentId) {
        // Delete the attachment from the server
        return attachmentMapper.deleteAttachment(attachmentId);
    }

    @Override
    public int updateAttachment(Attachment attachment) {
        // Update the attachment information on the server
        return attachmentMapper.updateAttachment(attachment);
    }

    @Override
    public Attachment getAttachment(int attachmentId) {
        // Retrieve the attachment information from the server
        return attachmentMapper.selectById(attachmentId);
    }
}
