package com.js_rom.test_app_backend.infrastructure.rest.http_errors;

public class ErrorMessage {

    private final String error;

    private final String message;

    public ErrorMessage(Exception exception) {
        this.error = exception.getClass().getSimpleName();
        this.message = exception.getMessage();
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "error='" + error + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
