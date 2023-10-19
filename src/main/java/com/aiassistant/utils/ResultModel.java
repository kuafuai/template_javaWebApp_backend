package com.aiassistant.utils;

import lombok.Data;

@Data
public class ResultModel<T> {

    private Exception exception;
    private T data;
    private String msg;
    private Integer code;

    public static <T> ResultModel<T> ofResult(Integer code, String msg, T data) {
        return ofResult(code, msg, data, null);
    }

    public static <T> ResultModel<T> ofResult(Integer code, String msg, T data, Exception exception) {
        ResultModel<T> resultModel = new ResultModel<>();
        resultModel.setCode(code);
        resultModel.setData(data);
        resultModel.setMsg(msg);
        resultModel.setException(exception);
        return resultModel;
    }

    public static ResultModel<?> ofSuccess() {
        return ofSuccess(null);
    }

    public static <T> ResultModel<T> ofSuccess(T data) {
        return ofSuccess(null, data);
    }

    public static <T> ResultModel<T> ofSuccess(String msg, T data) {
        return ofResult(0, msg, data);
    }

    public static ResultModel<?> ofError() {
        return ofError(null);
    }

    public static ResultModel<?> ofError(String msg) {
        return ofError(msg, null);
    }

    public static ResultModel<?> ofError(String msg, Exception exception) {
        return ofResult(999, msg, null, exception);
    }
}
