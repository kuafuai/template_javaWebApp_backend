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
    public ResultModel addAttachment(Attachment attachment) {
        attachmentMapper.insertAttachment(attachment);
        return ResultModel.ofSuccess(attachment);
    }

    @Override
    public ResultModel getAttachmentById(Integer id) {
        Attachment attachment = attachmentMapper.selectById(id);
        if (attachment != null) {
            return ResultModel.ofSuccess(attachment);
        } else {
            return ResultModel.ofError("Attachment not found");
        }
    }
}