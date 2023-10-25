package com.aiassistant.controller;

import com.aiassistant.model.Cable;
import com.aiassistant.service.CableService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/cable")
public class CableController {

    private final CableService cableService;

    @Autowired
    public CableController(CableService cableService) {
        this.cableService = cableService;
    }

    @PostMapping("/add")
    public ResultModel addCable(@RequestBody Cable cable) {
        return cableService.addCable(cable);
    }

    @GetMapping("/list")
    public ResultPageModel<Cable> getCableList() {
        return cableService.getCableList();
    }

    @GetMapping("/{id}")
    public ResultModel<Cable> getCableById(@PathVariable Integer id) {
        return cableService.getCableById(id);
    }

    @PostMapping("/upload")
    public ResultModel uploadFile(@RequestParam("file") MultipartFile file) {

        return cableService.uploadExcel(file);
    }

}
