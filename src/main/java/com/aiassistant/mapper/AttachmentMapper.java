package com.aiassistant.mapper;

import com.aiassistant.model.Attachment;

public interface AttachmentMapper {
    /**
     * Inserts an attachment into the database.
     * 
     * @param attachment The attachment to be inserted.
     */
    void insertAttachment(Attachment attachment);
    
    /**
     * Retrieves an attachment from the database based on its ID.
     * 
     * @param id The ID of the attachment to be retrieved.
     * @return The retrieved attachment.
     */
    Attachment selectById(String id);
    
    /**
     * Deletes an attachment from the database based on its ID.
     * 
     * @param id The ID of the attachment to be deleted.
     */
    void deleteById(String id);
}