package com.aiassistant.service;

import com.aiassistant.model.Table;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;

public interface TableService {
    ResultModel<Table> updateTableStatus(Integer tableId, Integer status);
    ResultPageModel<Table> getTableList();
    ResultModel<Table> getTableStatus(Integer tableId);
}