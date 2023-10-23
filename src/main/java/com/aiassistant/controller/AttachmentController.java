package com.aiassistant.controller;

import com.aiassistant.model.Attachment;
import com.aiassistant.service.AttachmentService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {
    private final AttachmentService attachmentService;

    @Autowired
    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @PostMapping("/add")
    public ResultModel addAttachment(@RequestBody Attachment attachment) {
        return attachmentService.addAttachment(attachment);
    }

    @GetMapping("/{id}")
    public ResultModel getAttachmentById(@PathVariable Integer id) {
        return attachmentService.getAttachmentById(id);
    }
}
