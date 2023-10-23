package com.aiassistant.service;

import com.aiassistant.model.Attachment;
import com.aiassistant.utils.ResultModel;

public interface AttachmentService {
    ResultModel addAttachment(Attachment attachment);

    ResultModel getAttachmentById(Integer id);
}
