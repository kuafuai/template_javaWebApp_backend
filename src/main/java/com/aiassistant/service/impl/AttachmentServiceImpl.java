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
    public ResultModel<Attachment> addAttachment(MultipartFile file, String filePath) {
        try {
            // Save the attachment file to the specified file path
            // You need to implement the logic to save the file here
            
            // Create a new Attachment object with the file details
            Attachment attachment = new Attachment();
            attachment.setFileName(file.getOriginalFilename());
            attachment.setFilePath(filePath);
            
            // Save the attachment details to the database
            attachmentMapper.addAttachment(attachment);
            
            // Return a success response with the attachment details
            return new ResultModel<>(attachment, "Attachment added successfully", 200);
        } catch (Exception e) {
            // Return an error response if there is an exception
            return new ResultModel<>(null, "Failed to add attachment", 500);
        }
    }

    @Override
    public ResultModel<Attachment> updateAttachment(String id, MultipartFile file, String filePath) {
        try {
            // Check if the attachment exists in the database
            Attachment existingAttachment = attachmentMapper.getAttachmentById(id);
            if (existingAttachment == null) {
                return new ResultModel<>(null, "Attachment not found", 404);
            }
            
            // Update the attachment file in the specified file path
            // You need to implement the logic to update the file here
            
            // Update the attachment details in the database
            existingAttachment.setFileName(file.getOriginalFilename());
            existingAttachment.setFilePath(filePath);
            attachmentMapper.updateAttachment(existingAttachment);
            
            // Return a success response with the updated attachment details
            return new ResultModel<>(existingAttachment, "Attachment updated successfully", 200);
        } catch (Exception e) {
            // Return an error response if there is an exception
            return new ResultModel<>(null, "Failed to update attachment", 500);
        }
    }

    @Override
    public ResultModel<Attachment> deleteAttachment(String id) {
        try {
            // Check if the attachment exists in the database
            Attachment existingAttachment = attachmentMapper.getAttachmentById(id);
            if (existingAttachment == null) {
                return new ResultModel<>(null, "Attachment not found", 404);
            }
            
            // Delete the attachment file from the file system
            // You need to implement the logic to delete the file here
            
            // Delete the attachment details from the database
            attachmentMapper.deleteAttachment(id);
            
            // Return a success response with the deleted attachment details
            return new ResultModel<>(existingAttachment, "Attachment deleted successfully", 200);
        } catch (Exception e) {
            // Return an error response if there is an exception
            return new ResultModel<>(null, "Failed to delete attachment", 500);
        }
    }

    @Override
    public ResultModel<Attachment> getAttachmentById(String id) {
        try {
            // Get the attachment details from the database
            Attachment attachment = attachmentMapper.getAttachmentById(id);
            if (attachment == null) {
                return new ResultModel<>(null, "Attachment not found", 404);
            }
            
            // Return a success response with the attachment details
            return new ResultModel<>(attachment, "Attachment retrieved successfully", 200);
        } catch (Exception e) {
            // Return an error response if there is an exception
            return new ResultModel<>(null, "Failed to retrieve attachment", 500);
        }
    }
}