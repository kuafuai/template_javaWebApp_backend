package com.aiassistant.config;

import com.aiassistant.utils.ResultModel;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MultipartException.class)
    public ResultModel uploadException(MaxUploadSizeExceededException e) {
        return ResultModel.ofError("上传文件过大【单个文件不得超过10M】");
    }
}
