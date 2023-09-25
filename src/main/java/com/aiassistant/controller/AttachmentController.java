package com.aiassistant.controller;

import com.aiassistant.model.AttachmentInfo;
import com.aiassistant.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {
    private final AttachmentService attachmentService;

    @Autowired
    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addAttachment(@RequestParam("file") @Valid MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File is empty");
        }
        if (file.getSize() > 10 * 1024 * 1024) {
            return ResponseEntity.badRequest().body("File size exceeds the limit of 10MB");
        }
        AttachmentInfo attachmentInfo = attachmentService.addAttachment(file);
        return ResponseEntity.ok(attachmentInfo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAttachmentById(@PathVariable("id") String id) {
        AttachmentInfo attachmentInfo = attachmentService.getAttachmentById(id);
        if (attachmentInfo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(attachmentInfo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAttachmentById(@PathVariable("id") String id) {
        attachmentService.deleteAttachmentById(id);
        return ResponseEntity.noContent().build();
    }
}
