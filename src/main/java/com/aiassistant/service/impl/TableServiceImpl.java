package com.aiassistant.service.impl;

import com.aiassistant.mapper.TableMapper;
import com.aiassistant.model.Table;
import com.aiassistant.service.TableService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableServiceImpl implements TableService {

    private final TableMapper tableMapper;

    @Autowired
    public TableServiceImpl(TableMapper tableMapper) {
        this.tableMapper = tableMapper;
    }

    @Override
    public ResultModel<Table> createTable(Table table) {
        try {
            tableMapper.createTable(table);
            return ResultModel.ofSuccess(table);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to create table", e);
        }
    }

    @Override
    public ResultModel<Table> updateTable(Table table) {
        try {
            tableMapper.updateTable(table);
            return ResultModel.ofSuccess(table);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to update table", e);
        }
    }

    @Override
    public ResultModel<Table> deleteTable(int id) {
        try {
            tableMapper.deleteTable(id);
            return ResultModel.ofSuccess();
        } catch (Exception e) {
            return ResultModel.ofError("Failed to delete table", e);
        }
    }

    @Override
    public ResultModel<Table> getTableById(int id) {
        try {
            Table table = tableMapper.getTableById(id);
            if (table != null) {
                return ResultModel.ofSuccess(table);
            } else {
                return ResultModel.ofError("Table not found");
            }
        } catch (Exception e) {
            return ResultModel.ofError("Failed to get table", e);
        }
    }
}
