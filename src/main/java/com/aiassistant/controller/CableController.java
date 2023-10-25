package com.aiassistant.controller;

import com.aiassistant.model.Cable;
import com.aiassistant.service.CableService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cable")
public class CableController {

    private final CableService cableService;

    @Autowired
    public CableController(CableService cableService) {
        this.cableService = cableService;
    }

    @PostMapping("/add")
    public ResultModel<Long> addCable(@RequestBody Cable cable) {
        return cableService.addCable(cable);
    }

    @GetMapping("/list")
    public ResultPageModel<Cable> getCableList() {
        return cableService.getCableList();
    }

    @GetMapping("/{id}")
    public ResultModel<Cable> getCableById(@PathVariable Long id) {
        return cableService.getCableById(id);
    }

    @PutMapping("/{id}")
    public ResultModel<Cable> updateCable(@PathVariable Long id, @RequestBody Cable cable) {
        return cableService.updateCable(id, cable);
    }

    @DeleteMapping("/{id}")
    public ResultModel<String> deleteCable(@PathVariable Long id) {
        return cableService.deleteCable(id);
    }
}
