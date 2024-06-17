package com.aiassistant.controller;

import com.aiassistant.model.Recommendation;
import com.aiassistant.model.TravelPlan;
import com.aiassistant.service.RecommendationService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendationController {
    private RecommendationService recommendationService;

    @Autowired
    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @PostMapping("/recommendation")
    public ResultModel<Recommendation> getRecommendation(@RequestBody TravelPlan travelPlan) {
        Recommendation recommendation = recommendationService.getRecommendation(travelPlan);
        return ResultModel.ofSuccess(recommendation);
    }
}