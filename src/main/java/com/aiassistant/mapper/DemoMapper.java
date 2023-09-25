package com.aiassistant.mapper;

import com.aiassistant.model.Demo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 持久化层--DemoMapper
 * 用于 Demo 演示，请勿直接修改
 */
@Mapper
public interface DemoMapper {

    /**
     * 插入一条目录记录
     *
     * @param demo
     */
    Demo insertDemo(Demo demo);

    /**
     * 查询所有目录记录
     *
     * @return
     */
    List<Demo> getDemoList();

    /**
     * 根据Id查询
     *
     * @param id
     * @return
     */
    Demo selectById(@Param("id") Integer id);
}