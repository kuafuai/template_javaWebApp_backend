package com.aiassistant.controller;

import com.aiassistant.service.AttachmentService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.model.Attachment;
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
    public ResultModel<Attachment> addAttachment(@RequestParam("file") MultipartFile file,
                                                 @RequestParam("fileType") Integer fileType) {
        return attachmentService.addAttachment(file, fileType);
    }

    @DeleteMapping("/delete/{attachmentId}")
    public ResultModel deleteAttachment(@PathVariable("attachmentId") Integer attachmentId) {
        return attachmentService.deleteAttachment(attachmentId);
    }

    @PutMapping("/update/{attachmentId}")
    public ResultModel updateAttachment(@PathVariable("attachmentId") Integer attachmentId,
                                        @RequestParam("file") MultipartFile file,
                                        @RequestParam("fileType") Integer fileType) {
        return attachmentService.updateAttachment(attachmentId, file, fileType);
    }

    @GetMapping("/{attachmentId}")
    public ResultModel<Attachment> getAttachmentById(@PathVariable("attachmentId") Integer attachmentId) {
        return attachmentService.getAttachmentById(attachmentId);
    }
}