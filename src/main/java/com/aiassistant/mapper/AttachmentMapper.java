package com.aiassistant.mapper;

import com.aiassistant.model.Attachment;

public interface AttachmentMapper {
    /**
     * Inserts a new attachment into the database.
     *
     * @param attachment The attachment to be inserted.
     * @return The inserted attachment.
     */
    Attachment insertAttachment(Attachment attachment);

    /**
     * Retrieves an attachment from the database based on its ID.
     *
     * @param id The ID of the attachment.
     * @return The retrieved attachment, or null if not found.
     */
    Attachment selectById(String id);

    /**
     * Deletes an attachment from the database based on its ID.
     *
     * @param id The ID of the attachment to be deleted.
     */
    void deleteById(String id);

    /**
     * Retrieves an attachment from the database based on its file name.
     *
     * @param fileName The file name of the attachment.
     * @return The retrieved attachment, or null if not found.
     */
    Attachment selectByFileName(String fileName);
}
