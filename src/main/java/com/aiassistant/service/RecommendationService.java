package com.aiassistant.service;

import com.aiassistant.model.Recommendation;
import com.aiassistant.model.TravelPlan;
import com.aiassistant.utils.ResultModel;

public interface RecommendationService {
    ResultModel<Recommendation> getRecommendation(TravelPlan travelPlan);
}
