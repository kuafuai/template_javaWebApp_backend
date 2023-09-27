package com.aiassistant.exception;

import com.aiassistant.controller.AdditionResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdditionExceptionHandler {

    @ExceptionHandler(Exception.class)
    public AdditionResponse handleException(Exception e) {
        AdditionResponse response = new AdditionResponse();
        response.setErrorMessage(e.getMessage());
        return response;
    }

    @ExceptionHandler(SubtractionException.class)
    public AdditionResponse handleSubtractionException(SubtractionException e) {
        AdditionResponse response = new AdditionResponse();
        response.setErrorMessage(e.getMessage());
        return response;
    }
}
