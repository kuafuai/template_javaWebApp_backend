package com.aiassistant.mapper;

import com.aiassistant.model.TravelPlan;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelPlanMapper {
    @Insert("INSERT INTO travel_plan(user_id, start_time, end_time, destination, remark) " +
            "VALUES(#{userId}, #{startTime}, #{endTime}, #{destination}, #{remark})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = int.class)
    int insertTravelPlan(TravelPlan travelPlan);
}
