package com.aiassistant.controller;

import com.aiassistant.model.Feedback;
import com.aiassistant.model.File;
import com.aiassistant.service.FeedbackService;
import com.aiassistant.service.FileService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    private FeedbackService feedbackService;
    private final FileService fileService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService, FileService fileService) {
        this.feedbackService = feedbackService;
        this.fileService = fileService;
    }

    @PostMapping("/add")
    public ResultModel addFeedback(@RequestBody Feedback feedback) {
        return feedbackService.addFeedback(feedback);
    }

    @PostMapping("/save")
    public ResultModel saveFeedback(@RequestParam("store") String store,
                                    @RequestParam("feedback") String feedback,
                                    @RequestParam("image") MultipartFile image) {
        try {
            log.info("{},{}", store, feedback);
            ResultModel<File> fileModel = fileService.saveFile(image);

            String imageUrl = fileModel.getData().getFileUrl();

            Feedback feedbackModel = new Feedback();
            feedbackModel.setStoreName(store);
            feedbackModel.setFeedbackText(feedback);
            feedbackModel.setImageUrl(imageUrl);

            feedbackService.addFeedback(feedbackModel);

            return ResultModel.ofSuccess();

        } catch (IOException e) {
            return ResultModel.ofError(e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResultPageModel<Feedback> getFeedbackList() {
        return feedbackService.getFeedbackList();
    }
}
