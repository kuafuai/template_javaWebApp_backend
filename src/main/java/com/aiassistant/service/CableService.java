package com.aiassistant.service;

import com.aiassistant.model.Cable;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;

public interface CableService {
    ResultModel<Long> addCable(Cable cable);
    ResultPageModel<Cable> getCableList();
    ResultModel<Cable> getCableById(Long id);
    ResultModel<Cable> updateCable(Long id, Cable cable);
    ResultModel<String> deleteCable(Long id);
}
