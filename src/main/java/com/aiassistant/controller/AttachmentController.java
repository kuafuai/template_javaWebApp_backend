package com.aiassistant.controller;

import com.aiassistant.model.Attachment;
import com.aiassistant.service.AttachmentService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ResultModel<Attachment>> addAttachment(@RequestParam("file") MultipartFile file,
                                                                 @RequestParam("name") String name) {
        
        ResultModel<Attachment> result = attachmentService.addAttachment(file, name);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PostMapping("/update")
    public ResponseEntity<ResultModel<Attachment>> updateAttachment(@RequestParam("id") String id,
                                                                    @RequestParam("file") MultipartFile file,
                                                                    @RequestParam("name") String name) {
        
        ResultModel<Attachment> result = attachmentService.updateAttachment(id, file, name);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/delete")
    public ResponseEntity<ResultModel<Attachment>> deleteAttachment(@RequestParam("id") String id) {
        
        ResultModel<Attachment> result = attachmentService.deleteAttachment(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultModel<Attachment>> getAttachmentById(@PathVariable("id") String id) {
        
        ResultModel<Attachment> result = attachmentService.getAttachmentById(id);
        return ResponseEntity.ok(result);
    }
}