package com.aiassistant.mapper;

import com.aiassistant.model.Attachment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AttachmentMapper {
    @Insert("INSERT INTO attachment (id, name, path, create_time) VALUES (#{id}, #{name}, #{path}, #{createTime})")
    int insertAttachment(Attachment attachment);

    @Select("SELECT * FROM attachment WHERE id = #{id}")
    List<Attachment> selectById(Integer id);

    @Update("UPDATE attachment SET name = #{name}, path = #{path}, create_time = #{createTime} WHERE id = #{id}")
    int updateAttachment(Attachment attachment);

    @Delete("DELETE FROM attachment WHERE id = #{id}")
    int deleteAttachment(Integer id);
}