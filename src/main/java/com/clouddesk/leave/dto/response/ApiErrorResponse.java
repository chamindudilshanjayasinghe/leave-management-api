package com.clouddesk.leave.dto.response;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class ApiErrorResponse {
    private int status;
    private String error;
    private String message;
    private OffsetDateTime timestamp;

    public ApiErrorResponse(int status, String error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.timestamp = OffsetDateTime.now();
    }
}
