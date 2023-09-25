package com.aiassistant.mapper;

import com.aiassistant.model.Attachment;

public interface AttachmentMapper {
    void insertAttachment(Attachment attachment);
    void deleteAttachment(Integer attachmentId);
    void updateAttachment(Attachment attachment);
    Attachment selectAttachmentById(Integer attachmentId);
}
