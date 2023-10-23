package com.aiassistant.mapper;

import com.aiassistant.model.Attachment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AttachmentMapper {
    @Insert("INSERT INTO attachment(name, type, url) VALUES(#{name}, #{type}, #{url})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertAttachment(Attachment attachment);

    @Select("SELECT * FROM attachment WHERE id = #{id}")
    Attachment selectById(Integer id);
}
