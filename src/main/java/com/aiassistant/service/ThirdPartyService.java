package com.aiassistant.service;

import com.aiassistant.utils.ResultModel;

public interface ThirdPartyService {
    ResultModel<String> accessThirdParty(String platform, String userId, String orderInfo);
}