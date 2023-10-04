package com.aiassistant.mapper;

import com.aiassistant.model.Attachment;
import org.apache.ibatis.annotations.*;

public interface AttachmentMapper {
    /**
     * Inserts a new attachment into the database.
     *
     * @param attachment The attachment to be inserted.
     * @return The inserted attachment.
     */
    @Insert("INSERT INTO attachments (id, fileName) VALUES (#{id}, #{fileName})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Attachment insertAttachment(Attachment attachment);

    /**
     * Retrieves an attachment from the database based on its ID.
     *
     * @param id The ID of the attachment.
     * @return The retrieved attachment, or null if not found.
     */
    @Select("SELECT * FROM attachments WHERE id = #{id}")
    Attachment selectById(String id);

    /**
     * Deletes an attachment from the database based on its ID.
     *
     * @param id The ID of the attachment to be deleted.
     */
    @Delete("DELETE FROM attachments WHERE id = #{id}")
    void deleteById(String id);

    /**
     * Retrieves an attachment from the database based on its file name.
     *
     * @param fileName The file name of the attachment.
     * @return The retrieved attachment, or null if not found.
     */
    @Select("SELECT * FROM attachments WHERE fileName = #{fileName}")
    Attachment selectByFileName(String fileName);
}
