package com.aiassistant.utils;

public class ResultModel<T> {
    private Integer code;
    private String msg;
    private T data;

    public ResultModel() {
    }

    public ResultModel(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResultModel<String> ofResult(Integer code, String msg, String data) {
        return new ResultModel<>(code, msg, data);
    }

    public static ResultModel<String> ofSuccess(String data) {
        return new ResultModel<>(200, "success", data);
    }

    public static ResultModel<String> ofError(String msg) {
        return new ResultModel<>(500, msg, null);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
