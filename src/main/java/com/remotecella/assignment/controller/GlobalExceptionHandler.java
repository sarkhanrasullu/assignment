package com.remotecella.assignment.controller;

import com.remotecella.assignment.controller.dto.CommonResponseDto;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger;

    public GlobalExceptionHandler(Logger logger) {
        this.logger = logger;
    }

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<CommonResponseDto<Object>> handle(Exception ex) {
        logger.error("internal-error",ex);
        return ResponseEntity.internalServerError().body(
                CommonResponseDto.error("something went wrong", ex.getMessage()));
    }

    @ExceptionHandler(value = NoSuchElementException.class)
    protected ResponseEntity<CommonResponseDto<Object>> handleNotFound(Exception ex) {
        logger.error("not-found-error",ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                CommonResponseDto.error(ex.getMessage(), ex.getMessage()));
    }

    @ExceptionHandler(value = BindException.class)
    protected ResponseEntity<CommonResponseDto<Object>> handleValidation(BindException ex) {
        logger.error("validation-error",ex);
        List<FieldError> fieldErrors = ex.getFieldErrors();
        StringBuilder messageBuilder = new StringBuilder();
        for(FieldError fieldError: fieldErrors) {
            messageBuilder.append(fieldError.getDefaultMessage()).append(";");
        }
        String message = messageBuilder.substring(0, messageBuilder.length()-1);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                CommonResponseDto.error(message, ex.getMessage()));
    }

}