package com.aiassistant.utils;

import java.util.Collections;
import java.util.List;

public class ResultPageModel<T> {

    private Integer totalRecords = 0;
    private Integer pageNo = 1;
    private Integer pageSize = 10;
    private Integer totalPage = 0;

    private transient Integer firstIndex;

    public Integer getFirstIndex() {
        return firstIndex;
    }

    private List<T> list;

    public static <T> ResultPageModel<T> of(List<T> list) {
        ResultPageModel<T> resultPageModel = new ResultPageModel<>();
        resultPageModel.setTotalRecords(list.size());
        resultPageModel.setList(list);
        return resultPageModel;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
        if (totalRecords != 0) {
            if (totalRecords % pageSize == 0) {
                totalPage = totalRecords / pageSize;
            } else {
                totalPage = totalRecords / pageSize + 1;
            }
        }
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if (pageNo < 1) {
            pageNo = 1;
        }
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize < 1) {
            pageSize = 1;
        }
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
