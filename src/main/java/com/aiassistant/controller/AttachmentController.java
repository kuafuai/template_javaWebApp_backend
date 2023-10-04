package com.aiassistant.controller;

import com.aiassistant.model.Attachment;
import com.aiassistant.service.AttachmentService;
import com.aiassistant.utils.ResultModel;
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
                                                 @RequestParam("name") String name) {
        return attachmentService.addAttachment(file, name);
    }

    @PostMapping("/update")
    public ResultModel<Attachment> updateAttachment(@RequestParam("id") String id,
                                                    @RequestParam("file") MultipartFile file,
                                                    @RequestParam("name") String name) {
        return attachmentService.updateAttachment(id, file, name);
    }

    @PostMapping("/delete")
    public ResultModel<Attachment> deleteAttachment(@RequestParam("id") String id) {
        return attachmentService.deleteAttachment(id);
    }

    @GetMapping("/{id}")
    public ResultModel<Attachment> getAttachmentById(@PathVariable("id") String id) {
        return attachmentService.getAttachmentById(id);
    }
}
