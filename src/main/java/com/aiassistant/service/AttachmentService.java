package com.aiassistant.service;

import com.aiassistant.model.AttachmentInfo;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {
    /**
     * Adds an attachment to the system.
     * 
     * @param file The file to be attached.
     * @return The information of the added attachment.
     */
    AttachmentInfo addAttachment(MultipartFile file);

    /**
     * Retrieves an attachment by its ID.
     * 
     * @param id The ID of the attachment.
     * @return The information of the retrieved attachment.
     */
    AttachmentInfo getAttachmentById(String id);

    /**
     * Deletes an attachment by its ID.
     * 
     * @param id The ID of the attachment to be deleted.
     */
    void deleteAttachmentById(String id);
}