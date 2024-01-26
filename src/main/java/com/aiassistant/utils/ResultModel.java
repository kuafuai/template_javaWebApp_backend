package com.aiassistant.utils;

public class ResultModel<T> {
    private Integer code;
    private String msg;
    private T data;
    private Exception exception;

    public ResultModel(Integer code, String msg, T data, Exception exception) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.exception = exception;
    }

    public static <T> ResultModel<T> ofResult(Integer code, String msg, T data) {
        return new ResultModel<>(code, msg, data, null);
    }

    public static <T> ResultModel<T> ofResult(Integer code, String msg, T data, Exception exception) {
        return new ResultModel<>(code, msg, data, exception);
    }

    public static <T> ResultModel<T> ofSuccess() {
        return new ResultModel<>(200, "success", null, null);
    }

    public static <T> ResultModel<T> ofSuccess(T data) {
        return new ResultModel<>(200, "success", data, null);
    }

    public static <T> ResultModel<T> ofSuccess(String msg, T data) {
        return new ResultModel<>(200, msg, data, null);
    }

    public static <T> ResultModel<T> ofError() {
        return new ResultModel<>(500, "error", null, null);
    }

    public static <T> ResultModel<T> ofError(String msg) {
        return new ResultModel<>(500, msg, null, null);
    }

    public static <T> ResultModel<T> ofError(String msg, Exception exception) {
        return new ResultModel<>(500, msg, null, exception);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
