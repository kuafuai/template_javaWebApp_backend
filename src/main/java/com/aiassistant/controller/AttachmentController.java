package com.aiassistant.controller;

import com.aiassistant.dto.AttachmentDTO;
import com.aiassistant.model.Attachment;
import com.aiassistant.service.AttachmentService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ResultModel<AttachmentDTO>> addAttachment(@Valid @RequestBody AttachmentDTO attachmentDTO) {
        Attachment attachment = attachmentService.addAttachment(attachmentDTO.getName(), attachmentDTO.getType(), attachmentDTO.getContent());
        AttachmentDTO responseDTO = new AttachmentDTO(attachment.getId(), attachment.getName(), attachment.getType(), attachment.getContent());
        ResultModel<AttachmentDTO> response = new ResultModel<>(responseDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultModel<AttachmentDTO>> getAttachmentById(@PathVariable int id) {
        Attachment attachment = attachmentService.getAttachmentById(id);
        AttachmentDTO responseDTO = new AttachmentDTO(attachment.getId(), attachment.getName(), attachment.getType(), attachment.getContent());
        ResultModel<AttachmentDTO> response = new ResultModel<>(responseDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResultModel<AttachmentDTO>> updateAttachment(@PathVariable int id, @Valid @RequestBody AttachmentDTO attachmentDTO) {
        Attachment attachment = attachmentService.updateAttachment(id, attachmentDTO.getName(), attachmentDTO.getType(), attachmentDTO.getContent());
        AttachmentDTO responseDTO = new AttachmentDTO(attachment.getId(), attachment.getName(), attachment.getType(), attachment.getContent());
        ResultModel<AttachmentDTO> response = new ResultModel<>(responseDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResultModel<Void>> deleteAttachment(@PathVariable int id) {
        attachmentService.deleteAttachment(id);
        ResultModel<Void> response = new ResultModel<>();
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }
}