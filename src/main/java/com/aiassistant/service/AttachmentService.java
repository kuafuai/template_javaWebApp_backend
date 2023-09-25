package com.aiassistant.service;

import com.aiassistant.model.Attachment;
import com.aiassistant.utils.ResultModel;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {
    ResultModel<Attachment> addAttachment(MultipartFile file, Integer fileType);
    ResultModel deleteAttachment(Integer attachmentId);
    ResultModel updateAttachment(Integer attachmentId, MultipartFile file, Integer fileType);
    ResultModel<Attachment> getAttachmentById(Integer attachmentId);
}
