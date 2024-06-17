package com.aiassistant.service;

import com.aiassistant.model.AppMetrics;
import com.aiassistant.model.PerformanceMetrics;
import com.aiassistant.utils.ResultModel;

import java.util.List;

public interface DemoService {
    ResultModel<PerformanceMetrics> getPerformanceMetrics();

    ResultModel<Boolean> checkResourceUsage(String appName);

    ResultModel<List<AppMetrics>> getAppList();

    ResultModel<Void> setThreshold(int threshold);

    ResultModel<Integer> getNetworkTraffic();

    ResultModel<Integer> getDiskUsage();
}
