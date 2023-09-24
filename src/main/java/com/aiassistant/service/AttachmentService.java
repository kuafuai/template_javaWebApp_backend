package com.aiassistant.service;

import com.aiassistant.model.Attachment;

public interface AttachmentService {
    int addAttachment(Attachment attachment);
    int deleteAttachment(int attachmentId);
    int updateAttachment(Attachment attachment);
    Attachment getAttachment(int attachmentId);
}
