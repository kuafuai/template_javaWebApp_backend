package com.aiassistant.controller;

import com.aiassistant.model.StoreFeedback;
import com.aiassistant.service.StoreFeedbackService;
import com.aiassistant.utils.ExcelUtils;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/storeFeedback")
public class StoreFeedbackController {

    @Autowired
    private StoreFeedbackService storeFeedbackService;

    @GetMapping("/generateExcel")
    public ResultModel generateExcel(HttpServletResponse response) {
        List<StoreFeedback> storeFeedbackList = storeFeedbackService.getStoreFeedbackList();
        try {
            ExcelUtils.generateExcel(response, storeFeedbackList);
        } catch (IOException e) {
            return ResultModel.ofError("Failed to generate excel file", e);
        }
        return ResultModel.ofSuccess();
    }

    @PostMapping("/addStoreFeedback")
    public ResultModel<StoreFeedback> addStoreFeedback(@RequestBody StoreFeedback storeFeedback) {
        storeFeedbackService.addStoreFeedback(storeFeedback);
        return ResultModel.ofSuccess(storeFeedback);
    }

    @GetMapping("/getStoreFeedbackList")
    public ResultModel<List<StoreFeedback>> getStoreFeedbackList() {
        List<StoreFeedback> storeFeedbackList = storeFeedbackService.getStoreFeedbackList();
        return ResultModel.ofSuccess(storeFeedbackList);
    }

    @GetMapping("/getStoreFeedbackById")
    public ResultModel<StoreFeedback> getStoreFeedbackById(@RequestParam Integer id) {
        StoreFeedback storeFeedback = storeFeedbackService.getStoreFeedbackById(id);
        return ResultModel.ofSuccess(storeFeedback);
    }

    @DeleteMapping("/deleteStoreFeedbackById")
    public ResultModel<StoreFeedback> deleteStoreFeedbackById(@RequestParam Integer id) {
        storeFeedbackService.deleteStoreFeedbackById(id);
        return ResultModel.ofSuccess();
    }

    @PutMapping("/updateStoreFeedback")
    public ResultModel<StoreFeedback> updateStoreFeedback(@RequestBody StoreFeedback storeFeedback) {
        storeFeedbackService.updateStoreFeedback(storeFeedback);
        return ResultModel.ofSuccess(storeFeedback);
    }
}
