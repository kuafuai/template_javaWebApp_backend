package com.aiassistant.service;

import com.aiassistant.model.Demo;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;

/**
 * 业务逻辑层--demo Service
 */
public interface DemoService {

    /**
     * 添加一条Demo
     *
     * @param demo
     */
    ResultModel<Demo> addDemo(Demo demo);

    /**
     * 获取所有
     *
     * @return
     */
    ResultPageModel<Demo> getDemoList();

    /**
     * 根据Id查询
     *
     * @param id
     * @return
     */
    Demo getById(Integer id);
}
