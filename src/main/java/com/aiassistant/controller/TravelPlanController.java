package com.aiassistant.controller;

import com.aiassistant.model.TravelPlan;
import com.aiassistant.service.TravelPlanService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TravelPlanController {
    private final TravelPlanService travelPlanService;

    @Autowired
    public TravelPlanController(TravelPlanService travelPlanService) {
        this.travelPlanService = travelPlanService;
    }

    @PostMapping("/travel-plan")
    public ResultModel<TravelPlan> publishTravelPlan(@RequestParam String title,
                                                     @RequestParam String description,
                                                     @RequestParam Date startTime,
                                                     @RequestParam Date endTime,
                                                     @RequestParam Integer limit) {
        return travelPlanService.publishTravelPlan(title, description, startTime, endTime, limit);
    }
}
