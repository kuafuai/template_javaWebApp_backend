package com.aiassistant.mapper;

import com.aiassistant.model.Attachment;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AttachmentMapper {
    @Insert("INSERT INTO attachment (attachment_name, attachment_type, attachment_size, attachment_content) " +
            "VALUES (#{attachmentName}, #{attachmentType}, #{attachmentSize}, #{attachmentContent})")
    int insertAttachment(Attachment attachment);

    @Delete("DELETE FROM attachment WHERE attachment_id = #{attachmentId}")
    int deleteAttachment(int attachmentId);

    @Update("UPDATE attachment SET attachment_name = #{attachmentName}, attachment_type = #{attachmentType}, " +
            "attachment_size = #{attachmentSize}, attachment_content = #{attachmentContent} " +
            "WHERE attachment_id = #{attachmentId}")
    int updateAttachment(Attachment attachment);

    @Select("SELECT * FROM attachment WHERE attachment_id = #{attachmentId}")
    Attachment selectById(int attachmentId);
}
