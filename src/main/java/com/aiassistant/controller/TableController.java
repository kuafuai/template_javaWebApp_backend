package com.aiassistant.controller;

import com.aiassistant.model.Table;
import com.aiassistant.service.TableService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/table")
public class TableController {
    @Autowired
    private TableService tableService;

    @PutMapping("/{tableId}/status/{status}")
    public ResultModel<Table> updateTableStatus(@PathVariable Integer tableId, @PathVariable Integer status) {
        return tableService.updateTableStatus(tableId, status);
    }

    @GetMapping("/list")
    public ResultPageModel<Table> getTableList() {
        return tableService.getTableList();
    }

    @GetMapping("/{tableId}/status")
    public ResultModel<Table> getTableStatus(@PathVariable Integer tableId) {
        return tableService.getTableStatus(tableId);
    }
}
