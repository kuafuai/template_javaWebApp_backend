package com.aiassistant.mapper;

import com.aiassistant.model.Demo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DemoMapper {

    void insertDemo(Demo demo);

    List<Demo> getDemoList();

    Demo selectById(Integer id);
}
