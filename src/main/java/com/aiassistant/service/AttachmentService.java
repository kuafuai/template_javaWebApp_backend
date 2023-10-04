package com.aiassistant.service;

import com.aiassistant.model.Attachment;
import com.aiassistant.utils.ResultModel;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {
    ResultModel<Attachment> addAttachment(MultipartFile file, String fileType);

    ResultModel<Attachment> updateAttachment(String id, MultipartFile file, String fileType);

    ResultModel<Attachment> deleteAttachment(String id);

    ResultModel<Attachment> getAttachmentById(String id);

    ResultModel<List<Attachment>> getAttachmentsByUserId(String userId);
}
