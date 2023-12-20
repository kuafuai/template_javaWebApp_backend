package com.aiassistant.service;

import com.aiassistant.model.Cable;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.web.multipart.MultipartFile;

public interface CableService {
    ResultModel addCable(Cable cable);

    ResultPageModel<Cable> getCableList();

    ResultPageModel<Cable> getCableListByProductCode(String productCode, Integer pageNum, Integer pageSize);

    ResultModel<Cable> getCableById(Integer id);

    ResultModel uploadExcel(MultipartFile file);

    String print(String productCode, String number);
}
