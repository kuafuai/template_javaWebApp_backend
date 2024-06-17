package com.aiassistant.controller;

import com.aiassistant.model.Message;
import com.aiassistant.service.ChatService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ChatController {
    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/sendMessage")
    public ResultModel<Message> sendMessage(@RequestParam String content,
                                            @RequestParam(required = false) MultipartFile image,
                                            @RequestParam(required = false) MultipartFile video) {
        return chatService.sendMessage(content, image, video);
    }
}
