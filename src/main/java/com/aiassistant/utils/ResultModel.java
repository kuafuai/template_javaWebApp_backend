package com.aiassistant.utils;

import lombok.Data;

/**
 * 控制层-对外返回数据结构
 *
 * @param <T>
 */
@Data
public class ResultModel<T> {

    private Exception exception = null;
    private T data = null;
    private String msg;
    private Integer code;

    /**
     * Create a ResultModel instance with the given code, message, data, and exception.
     *
     * @param code      the code of the result
     * @param msg       the message of the result
     * @param data      the data of the result
     * @param exception the exception of the result
     * @param <T>       the type of the data
     * @return a ResultModel instance
     * @throws IllegalArgumentException if the code is null
     */
    public static <T> ResultModel<T> ofResult(Integer code, String msg, T data, Exception exception) {
        if (code == null) {
            throw new IllegalArgumentException("Code cannot be null");
        }
        ResultModel<T> resultModel = new ResultModel<>();
        resultModel.setCode(code);
        resultModel.setData(data);
        resultModel.setMsg(msg);
        resultModel.setException(exception);
        return resultModel;
    }

    /**
     * Create a success ResultModel instance without any data.
     *
     * @return a ResultModel instance
     */
    public static ResultModel<Void> ofSuccess() {
        return ofSuccess(null);
    }

    /**
     * Create a success ResultModel instance with the given data.
     *
     * @param data the data of the result
     * @param <T>  the type of the data
     * @return a ResultModel instance
     */
    public static <T> ResultModel<T> ofSuccess(T data) {
        return ofSuccess(null, data);
    }

    /**
     * Create a success ResultModel instance with the given message and data.
     *
     * @param msg  the message of the result
     * @param data the data of the result
     * @param <T>  the type of the data
     * @return a ResultModel instance
     */
    public static <T> ResultModel<T> ofSuccess(String msg, T data) {
        return ofResult(0, msg, data);
    }

    /**
     * Create an error ResultModel instance without any message or exception.
     *
     * @return a ResultModel instance
     */
    public static ResultModel<Void> ofError() {
        return ofError(null);
    }

    /**
     * Create an error ResultModel instance with the given message.
     *
     * @param msg the message of the result
     * @return a ResultModel instance
     */
    public static ResultModel<Void> ofError(String msg) {
        return ofError(msg, null);
    }

    /**
     * Create an error ResultModel instance with the given message and exception.
     *
     * @param msg       the message of the result
     * @param exception the exception of the result
     * @return a ResultModel instance
     */
    public static ResultModel<Void> ofError(String msg, Exception exception) {
        return ofResult(999, msg, null, exception);
    }
}
