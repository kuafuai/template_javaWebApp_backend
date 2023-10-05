package com.aiassistant.controller;

import com.aiassistant.model.Attachment;
import com.aiassistant.service.AttachmentService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {

    private final AttachmentService attachmentService;

    @Autowired
    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @PostMapping("/add")
    public ResultModel<Attachment> addAttachment(@RequestParam("file") MultipartFile file) {
        return attachmentService.addAttachment(file);
    }

    @GetMapping("/{id}")
    public ResultModel<Attachment> getAttachmentById(@PathVariable Integer id) {
        return attachmentService.getAttachmentById(id);
    }

    @GetMapping("/all")
    public ResultPageModel<Attachment> getAllAttachments() {
        return attachmentService.getAllAttachments();
    }

    @PutMapping("/{id}")
    public ResultModel<Attachment> updateAttachment(@PathVariable Integer id, @RequestParam("file") MultipartFile file) {
        return attachmentService.updateAttachment(id, file);
    }

    @DeleteMapping("/{id}")
    public ResultModel<Attachment> deleteAttachment(@PathVariable Integer id) {
        return attachmentService.deleteAttachment(id);
    }
}
