package com.aiassistant.utils;

import java.util.List;

public class ResultPageModel<T> extends ResultModel<T> {
    private Integer totalRecords;
    private Integer pageNo;
    private Integer pageSize;
    private Integer totalPage;
    private Integer firstIndex;
    private List<T> list;

    public ResultPageModel() {
    }

    public ResultPageModel(List<T> list) {
        this.list = list;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getFirstIndex() {
        return firstIndex;
    }

    public void setFirstIndex(Integer firstIndex) {
        this.firstIndex = firstIndex;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public static <T> ResultPageModel<T> of(List<T> list) {
        ResultPageModel<T> result = new ResultPageModel<>(list);
        return result;
    }
}
