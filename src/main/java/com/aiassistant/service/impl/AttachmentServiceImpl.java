package com.aiassistant.service.impl;

import com.aiassistant.mapper.AttachmentMapper;
import com.aiassistant.model.Attachment;
import com.aiassistant.service.AttachmentService;
import com.aiassistant.utils.ResultModel;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

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
            File destFile = new File(filePath);
            FileUtils.copyInputStreamToFile(file.getInputStream(), destFile);

            // Create a new Attachment object with the file details
            Attachment attachment = new Attachment();
            attachment.setFileName(file.getOriginalFilename());
            attachment.setFileSize(file.getSize());
            attachment.setCreateTime(new Date());
            attachment.setFilePath(filePath);

            // Save the attachment details to the database
            attachmentMapper.insertAttachment(attachment);

            // Return a success response with the attachment details
            return new ResultModel<>(attachment, "Attachment added successfully", 200);
        } catch (IOException e) {
            // Return an error response if there is an exception
            return new ResultModel<>(null, "Failed to add attachment", 500);
        }
    }

    @Override
    public ResultModel<Attachment> updateAttachment(String id, MultipartFile file, String filePath) {
        try {
            // Check if the attachment exists in the database
            Attachment existingAttachment = attachmentMapper.selectById(id);
            if (existingAttachment == null) {
                return new ResultModel<>(null, "Attachment not found", 404);
            }

            // Update the attachment file in the specified file path
            File destFile = new File(filePath);
            FileUtils.copyInputStreamToFile(file.getInputStream(), destFile);

            // Update the attachment details in the database
            existingAttachment.setFileName(file.getOriginalFilename());
            existingAttachment.setFileSize(file.getSize());
            existingAttachment.setCreateTime(new Date());
            existingAttachment.setFilePath(filePath);
            attachmentMapper.updateAttachment(existingAttachment);

            // Return a success response with the updated attachment details
            return new ResultModel<>(existingAttachment, "Attachment updated successfully", 200);
        } catch (IOException e) {
            // Return an error response if there is an exception
            return new ResultModel<>(null, "Failed to update attachment", 500);
        }
    }

    @Override
    public ResultModel<Attachment> deleteAttachment(String id) {
        try {
            // Check if the attachment exists in the database
            Attachment existingAttachment = attachmentMapper.selectById(id);
            if (existingAttachment == null) {
                return new ResultModel<>(null, "Attachment not found", 404);
            }

            // Delete the attachment file from the file system
            File file = new File(existingAttachment.getFilePath());
            if (file.exists()) {
                file.delete();
            }

            // Delete the attachment details from the database
            attachmentMapper.deleteById(id);

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
            Attachment attachment = attachmentMapper.selectById(id);
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
