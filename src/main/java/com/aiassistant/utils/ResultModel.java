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

    public static <T> ResultModel<T> ofResult(Integer code, String msg, T data) {
        return new ResultModel<>(code, msg, data);
    }

    public static <T> ResultModel<T> ofSuccess(T data) {
        return new ResultModel<>(200, "success", data);
    }

    public static <T> ResultModel<T> ofError(String msg) {
        return new ResultModel<>(500, msg, null);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
