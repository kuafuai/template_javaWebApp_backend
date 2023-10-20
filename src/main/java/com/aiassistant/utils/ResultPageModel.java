package com.aiassistant.utils;

import java.util.Collections;
import java.util.List;

public class ResultPageModel<T> {

    private Integer totalRecords = 0;
    private Integer pageNo = 1;
    private Integer pageSize = 10;
    private Integer totalPage = 0;

    private transient Integer firstIndex;

    private List<T> list;

    public ResultPageModel() {
    }

    public ResultPageModel(List<T> list) {
        this.list = list;
        this.totalRecords = list.size();
        calculateTotalPage();
    }

    public Integer getFirstIndex() {
        return firstIndex;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
        calculateTotalPage();
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if (pageNo < 1) {
            throw new IllegalArgumentException("Page number cannot be less than 1");
        }
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize < 1) {
            throw new IllegalArgumentException("Page size cannot be less than 1");
        }
        this.pageSize = pageSize;
        calculateTotalPage();
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
        this.totalRecords = list.size();
        calculateTotalPage();
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    private void calculateTotalPage() {
        if (totalRecords != 0) {
            if (totalRecords % pageSize == 0) {
                totalPage = totalRecords / pageSize;
            } else {
                totalPage = totalRecords / pageSize + 1;
            }
        }
    }

    public static ResultPageModel ofError() {
        return new ResultPageModel(Collections.emptyList());
    }

    public static Integer getCode() {
        return 200;
    }
}
