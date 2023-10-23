package com.aiassistant.service;

import com.aiassistant.model.Attachment;
import com.aiassistant.utils.ResultModel;

public interface AttachmentService {
    ResultModel<Attachment> addAttachment(Attachment attachment);

    ResultModel<Attachment> getAttachmentById(Integer id);
}
