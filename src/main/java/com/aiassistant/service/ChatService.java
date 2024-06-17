package com.aiassistant.service;

import com.aiassistant.mapper.MessageMapper;
import com.aiassistant.model.Message;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ChatService {
    private final MessageMapper messageMapper;

    @Autowired
    public ChatService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    public ResultModel<Message> sendMessage(String content, MultipartFile image, MultipartFile video) {
        // Save the message to the database
        Message message = new Message();
        message.setContent(content);
        message.setImage(image != null ? image.getOriginalFilename() : null);
        message.setVideo(video != null ? video.getOriginalFilename() : null);
        messageMapper.insertMessage(message);

        // Return the message object
        return ResultModel.ofSuccess(message);
    }
}
