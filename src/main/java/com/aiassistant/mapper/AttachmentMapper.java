package com.aiassistant.mapper;

import com.aiassistant.model.Attachment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AttachmentMapper {
    int insertAttachment(Attachment attachment);
    List<Attachment> getAttachmentList();
    Attachment selectById(Integer id);
}
