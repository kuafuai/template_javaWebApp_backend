package com.aiassistant.service;

import com.aiassistant.model.Cable;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;

public interface CableService {
    ResultModel addCable(Cable cable);
    ResultPageModel<Cable> getCableList();
    ResultModel<Cable> getCableById(Integer id);
}
