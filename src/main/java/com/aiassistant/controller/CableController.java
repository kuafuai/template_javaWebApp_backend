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
@CrossOrigin(origins = {"*"})
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
    public ResultPageModel<Cable> getCableList(@RequestParam(value = "productCode", required = false, defaultValue = "") String productCode,
                                               @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                               @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        return cableService.getCableListByProductCode(productCode, pageNum, pageSize);
    }

    @GetMapping("/{id}")
    public ResultModel<Cable> getCableById(@PathVariable Integer id) {
        return cableService.getCableById(id);
    }

    @PostMapping("/upload")
    public ResultModel uploadFile(@RequestParam("file") MultipartFile file) {

        return cableService.uploadExcel(file);
    }

    @GetMapping("/print")
    public ResultModel print(@RequestParam(value = "productCode", required = false, defaultValue = "") String productCode,
                             @RequestParam(value = "number", required = false, defaultValue = "") String number,
                             @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) {

        String html = cableService.print(productCode, number);
        return ResultModel.ofSuccess(html);
    }

}
