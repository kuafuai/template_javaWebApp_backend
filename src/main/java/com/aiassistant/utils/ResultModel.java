package com.aiassistant.utils;

import lombok.Data;

@Data
public class ResultModel<T> {

    private Exception exception = null;
    private T data = null;
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

    public static ResultModel<Void> ofSuccess() {
        return ofSuccess(null);
    }

    public static <T> ResultModel<T> ofSuccess(T data) {
        return ofSuccess(null, data);
    }

    public static <T> ResultModel<T> ofSuccess(String msg, T data) {
        return ofResult(0, msg, data);
    }

    public static ResultModel<Void> ofError() {
        return ofError(null);
    }

    public static ResultModel<Void> ofError(String msg) {
        return ofError(msg, null);
    }

    public static ResultModel<Void> ofError(String msg, Exception exception) {
        return ofResult(999, msg, null, exception);
    }
}
