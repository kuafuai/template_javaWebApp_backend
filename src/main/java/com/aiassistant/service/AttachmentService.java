package com.aiassistant.service;

import com.aiassistant.model.Attachment;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {
    ResultModel<Attachment> addAttachment(MultipartFile file);

    ResultModel<Attachment> getAttachmentById(Integer id);

    ResultPageModel<Attachment> getAllAttachments();

    ResultModel<Attachment> updateAttachment(Integer id, MultipartFile file);

    ResultModel<Attachment> deleteAttachment(Integer id);
}
