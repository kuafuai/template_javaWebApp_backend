package com.aiassistant.controller;

import com.aiassistant.model.Attachment;
import com.aiassistant.service.AttachmentService;
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
    public int addAttachment(@RequestBody Attachment attachment) {
        return attachmentService.addAttachment(attachment);
    }

    @DeleteMapping("/delete/{attachmentId}")
    public int deleteAttachment(@PathVariable int attachmentId) {
        return attachmentService.deleteAttachment(attachmentId);
    }

    @PutMapping("/update/{attachmentId}")
    public int updateAttachment(@PathVariable int attachmentId, @RequestBody Attachment attachment) {
        attachment.setAttachmentId(attachmentId);
        return attachmentService.updateAttachment(attachment);
    }

    @GetMapping("/get/{attachmentId}")
    public Attachment getAttachment(@PathVariable int attachmentId) {
        return attachmentService.getAttachment(attachmentId);
    }
}