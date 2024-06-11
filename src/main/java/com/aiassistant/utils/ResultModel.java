package com.aiassistant.utils;

public class ResultModel<T> {
    private Exception exception;
    private T data;
    private String msg;
    private Integer code;

    public static <T> ResultModel<T> ofResult(Integer code, String msg, T data) {
        ResultModel<T> resultModel = new ResultModel<>();
        resultModel.setCode(code);
        resultModel.setMsg(msg);
        resultModel.setData(data);
        return resultModel;
    }

    public static <T> ResultModel<T> ofResult(Integer code, String msg, T data, Exception exception) {
        ResultModel<T> resultModel = new ResultModel<>();
        resultModel.setCode(code);
        resultModel.setMsg(msg);
        resultModel.setData(data);
        resultModel.setException(exception);
        return resultModel;
    }

    public static <T> ResultModel<T> ofSuccess() {
        return ofResult(200, "success", null);
    }

    public static <T> ResultModel<T> ofSuccess(T data) {
        return ofResult(200, "success", data);
    }

    public static <T> ResultModel<T> ofSuccess(String msg, T data) {
        return ofResult(200, msg, data);
    }

    public static <T> ResultModel<T> ofError() {
        return ofResult(500, "error", null);
    }

    public static <T> ResultModel<T> ofError(String msg) {
        return ofResult(500, msg, null);
    }

    public static <T> ResultModel<T> ofError(String msg, Exception exception) {
        return ofResult(500, msg, null, exception);
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
