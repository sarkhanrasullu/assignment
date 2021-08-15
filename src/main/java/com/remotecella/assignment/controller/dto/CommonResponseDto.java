package com.remotecella.assignment.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class CommonResponseDto<T> {

    private String message;
    private String systemMessage;
    private T data;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime timestamp;

    public static <T> CommonResponseDto<T> success(T data) {
        return new CommonResponseDto<T>()
                .setMessage("success")
                .setSystemMessage("success")
                .setData(data)
                .setTimestamp(LocalDateTime.now());
    }

    public static <T> CommonResponseDto<T> error(String message, String systemMessage) {
        return new CommonResponseDto<T>()
                .setMessage(message)
                .setSystemMessage(systemMessage)
                .setTimestamp(LocalDateTime.now());
    }

    public String getMessage() {
        return message;
    }

    public CommonResponseDto<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public CommonResponseDto<T> setData(T data) {
        this.data = data;
        return this;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public CommonResponseDto<T> setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getSystemMessage() {
        return systemMessage;
    }

    public CommonResponseDto<T> setSystemMessage(String systemMessage) {
        this.systemMessage = systemMessage;
        return this;
    }
}
