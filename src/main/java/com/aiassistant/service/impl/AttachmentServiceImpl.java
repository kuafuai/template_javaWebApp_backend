package com.aiassistant.service.impl;

import com.aiassistant.mapper.AttachmentMapper;
import com.aiassistant.model.Attachment;
import com.aiassistant.service.AttachmentService;
import com.aiassistant.utils.ResultModel;
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
    public ResultModel<Attachment> addAttachment(Attachment attachment) {
        attachmentMapper.insertAttachment(attachment);
        return new ResultModel<>(attachment);
    }

    @Override
    public ResultModel<Attachment> getAttachmentById(Integer id) {
        Attachment attachment = attachmentMapper.selectById(id);
        if (attachment != null) {
            return new ResultModel<>(attachment);
        } else {
            return new ResultModel<>(ResultModel.FAIL, "Attachment not found");
        }
    }
}