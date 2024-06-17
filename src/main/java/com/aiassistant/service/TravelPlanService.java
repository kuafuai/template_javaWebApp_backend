package com.aiassistant.service;

import com.aiassistant.mapper.TravelPlanMapper;
import com.aiassistant.model.TravelPlan;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TravelPlanService {
    private final TravelPlanMapper travelPlanMapper;

    @Autowired
    public TravelPlanService(TravelPlanMapper travelPlanMapper) {
        this.travelPlanMapper = travelPlanMapper;
    }

    public ResultModel<TravelPlan> publishTravelPlan(String title, String description, Date startTime, Date endTime, Integer limit) {
        TravelPlan travelPlan = new TravelPlan();
        travelPlan.setTitle(title);
        travelPlan.setDescription(description);
        travelPlan.setStartTime(startTime);
        travelPlan.setEndTime(endTime);
        travelPlan.setLimit(limit);

        travelPlanMapper.insertTravelPlan(travelPlan);

        return ResultModel.ofSuccess(travelPlan);
    }
}
