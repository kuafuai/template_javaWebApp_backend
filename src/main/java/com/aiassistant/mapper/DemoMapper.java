package com.aiassistant.mapper;

import com.aiassistant.model.Demo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DemoMapper {
    Demo insertDemo(Demo demo);

    List<Demo> getDemoList();

    Demo selectById(Integer id);

    List<String> generateEmojis(@Param("text") String text, @Param("numEmojis") int numEmojis);
}
