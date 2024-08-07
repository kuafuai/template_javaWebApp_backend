package com.aiassistant.mapper;

import com.aiassistant.model.FirePoint;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FirePointMapper {
    FirePoint selectFirePointById(@Param("id") String id);
}
