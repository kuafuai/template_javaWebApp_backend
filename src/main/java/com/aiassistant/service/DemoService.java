package com.aiassistant.service;

import com.aiassistant.model.Demo;
import com.aiassistant.utils.ResultPageModel;

public interface DemoService {
    ResultPageModel<Demo> getDemoListByType(String messageType, Integer pageNo, Integer pageSize);
}
