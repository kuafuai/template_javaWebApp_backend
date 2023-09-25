package com.aiassistant.service.impl;

import com.aiassistant.mapper.AttachmentMapper;
import com.aiassistant.model.Attachment;
import com.aiassistant.service.AttachmentService;
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
    public AttachmentInfo addAttachment(MultipartFile file) {
        // Implement the logic to add the attachment
        Attachment attachment = new Attachment();
        attachment.setFileName(file.getOriginalFilename());
        attachment.setFileSize(file.getSize());
        attachment.setFileType(file.getContentType());
        attachment.setData(file.getBytes());
        
        attachmentMapper.addAttachment(attachment);
        
        AttachmentInfo attachmentInfo = new AttachmentInfo();
        attachmentInfo.setId(attachment.getId());
        attachmentInfo.setFileName(attachment.getFileName());
        attachmentInfo.setFileSize(attachment.getFileSize());
        attachmentInfo.setFileType(attachment.getFileType());
        
        return attachmentInfo;
    }

    @Override
    public AttachmentInfo getAttachmentById(String id) {
        // Implement the logic to get the attachment by id
        Attachment attachment = attachmentMapper.getAttachmentById(id);
        
        if (attachment == null) {
            throw new AttachmentNotFoundException("Attachment not found with id: " + id);
        }
        
        AttachmentInfo attachmentInfo = new AttachmentInfo();
        attachmentInfo.setId(attachment.getId());
        attachmentInfo.setFileName(attachment.getFileName());
        attachmentInfo.setFileSize(attachment.getFileSize());
        attachmentInfo.setFileType(attachment.getFileType());
        
        return attachmentInfo;
    }

    @Override
    public void deleteAttachmentById(String id) {
        // Implement the logic to delete the attachment by id
        Attachment attachment = attachmentMapper.getAttachmentById(id);
        
        if (attachment == null) {
            throw new AttachmentNotFoundException("Attachment not found with id: " + id);
        }
        
        attachmentMapper.deleteAttachmentById(id);
    }
}