package com.aiassistant.controller;

import com.aiassistant.service.HelmService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/helm")
public class HelmController {

    private final HelmService helmService;

    @Autowired
    public HelmController(HelmService helmService) {
        this.helmService = helmService;
    }

    @PostMapping("/upload")
    public ResultModel uploadHelmPackage(@RequestParam("file") MultipartFile file) {
        try {
            helmService.uploadHelmPackage(file);
            return ResultModel.ofSuccess();
        } catch (Exception e) {
            return ResultModel.ofError(e.getMessage(), e);
        }
    }

    @GetMapping("/config")
    public ResultModel getHelmConfig() {
        try {
            Map<String, Object> config = helmService.getHelmConfig();
            return ResultModel.ofSuccess(config);
        } catch (Exception e) {
            return ResultModel.ofError(e.getMessage(), e);
        }
    }

    @PostMapping("/config")
    public ResultModel updateHelmConfig(@RequestBody Map<String, Object> config) {
        try {
            helmService.updateHelmConfig(config);
            return ResultModel.ofSuccess();
        } catch (Exception e) {
            return ResultModel.ofError(e.getMessage(), e);
        }
    }

    @PostMapping("/deploy")
    public ResultModel deployHelmPackage() {
        try {
            helmService.deployHelmPackage();
            return ResultModel.ofSuccess();
        } catch (Exception e) {
            return ResultModel.ofError(e.getMessage(), e);
        }
    }

    @ExceptionHandler(Exception.class)
    public ResultModel handleException(Exception e) {
        return ResultModel.ofError(e.getMessage(), e);
    }

    @ExceptionHandler(Error.class)
    public ResultModel handleError(Error e) {
        return ResultModel.ofError(e.getMessage(), e);
    }
}
