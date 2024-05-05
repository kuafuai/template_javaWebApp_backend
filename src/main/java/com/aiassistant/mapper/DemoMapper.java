package com.aiassistant.mapper;

import com.aiassistant.model.Demo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DemoMapper {
    Demo insertDemo(Demo demo);

    List<Demo> getDemoList();

    List<Demo> getDemoListByType(@Param("messageType") String messageType);

    Demo selectById(Integer id);
}
