package com.aiassistant.service.impl;

import com.aiassistant.mapper.AttachmentMapper;
import com.aiassistant.model.Attachment;
import com.aiassistant.service.AttachmentService;
import com.aiassistant.utils.ResultModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AttachmentServiceImpl.class);

    private final AttachmentMapper attachmentMapper;

    @Autowired
    public AttachmentServiceImpl(AttachmentMapper attachmentMapper) {
        this.attachmentMapper = attachmentMapper;
    }

    @Override
    public ResultModel<Attachment> addAttachment(Attachment attachment) {
        try {
            attachmentMapper.insertAttachment(attachment);
            return new ResultModel<>(attachment);
        } catch (Exception e) {
            LOGGER.error("Error occurred while adding attachment: {}", e.getMessage());
            return new ResultModel<>("Failed to add attachment");
        }
    }

    @Override
    public ResultModel<Attachment> deleteAttachment(Integer id) {
        try {
            attachmentMapper.deleteAttachment(id);
            return new ResultModel<>();
        } catch (Exception e) {
            LOGGER.error("Error occurred while deleting attachment: {}", e.getMessage());
            return new ResultModel<>("Failed to delete attachment");
        }
    }

    @Override
    public ResultModel<Attachment> updateAttachment(Attachment attachment) {
        try {
            attachmentMapper.updateAttachment(attachment);
            return new ResultModel<>(attachment);
        } catch (Exception e) {
            LOGGER.error("Error occurred while updating attachment: {}", e.getMessage());
            return new ResultModel<>("Failed to update attachment");
        }
    }

    @Override
    public ResultModel<Attachment> getAttachmentById(Integer id) {
        try {
            Attachment attachment = attachmentMapper.selectAttachmentById(id);
            return new ResultModel<>(attachment);
        } catch (Exception e) {
            LOGGER.error("Error occurred while retrieving attachment: {}", e.getMessage());
            return new ResultModel<>("Failed to retrieve attachment");
        }
    }
}