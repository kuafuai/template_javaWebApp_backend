package com.aiassistant.controller;

import com.aiassistant.model.Attachment;
import com.aiassistant.service.AttachmentService;
import com.aiassistant.utils.ResultModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AttachmentControllerTest {
    private MockMvc mockMvc;

    @Mock
    private AttachmentService attachmentService;

    @InjectMocks
    private AttachmentController attachmentController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(attachmentController).build();
    }

    @Test
    public void testAddAttachment() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file", "test.txt", "text/plain", "Test data".getBytes());
        Attachment attachment = new Attachment();
        attachment.setAttachmentId(1);
        attachment.setFileName("test.txt");
        attachment.setFileSize(10L);
        attachment.setFileType(1);
        attachment.setUploadTime(new Date());
        attachment.setDownloadUrl("http://localhost:8080/attachments/1");

        ResultModel<Attachment> resultModel = new ResultModel<>(attachment);
        when(attachmentService.addAttachment(any(), any())).thenReturn(resultModel);

        mockMvc.perform(multipart("/attachments")
                .file(file)
                .param("fileType", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.attachmentId").value(1))
                .andExpect(jsonPath("$.data.fileName").value("test.txt"))
                .andExpect(jsonPath("$.data.fileSize").value(10))
                .andExpect(jsonPath("$.data.fileType").value(1))
                .andExpect(jsonPath("$.data.uploadTime").exists())
                .andExpect(jsonPath("$.data.downloadUrl").value("http://localhost:8080/attachments/1"));
    }

    @Test
    public void testDeleteAttachment() throws Exception {
        mockMvc.perform(delete("/attachments/{id}", 1))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateAttachment() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file", "test.txt", "text/plain", "Test data".getBytes());

        mockMvc.perform(multipart("/attachments/{id}", 1)
                .file(file)
                .param("fileType", "1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAttachmentById() throws Exception {
        Attachment attachment = new Attachment();
        attachment.setAttachmentId(1);
        attachment.setFileName("test.txt");
        attachment.setFileSize(10L);
        attachment.setFileType(1);
        attachment.setUploadTime(new Date());
        attachment.setDownloadUrl("http://localhost:8080/attachments/1");

        ResultModel<Attachment> resultModel = new ResultModel<>(attachment);
        when(attachmentService.getAttachmentById(1)).thenReturn(resultModel);

        mockMvc.perform(get("/attachments/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.attachmentId").value(1))
                .andExpect(jsonPath("$.data.fileName").value("test.txt"))
                .andExpect(jsonPath("$.data.fileSize").value(10))
                .andExpect(jsonPath("$.data.fileType").value(1))
                .andExpect(jsonPath("$.data.uploadTime").exists())
                .andExpect(jsonPath("$.data.downloadUrl").value("http://localhost:8080/attachments/1"));
    }
}
