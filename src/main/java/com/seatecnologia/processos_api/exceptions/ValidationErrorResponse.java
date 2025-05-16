package com.seatecnologia.processos_api.exceptions;

import java.time.LocalDateTime;
import java.util.List;

public class ValidationErrorResponse {

    private LocalDateTime timestamp;
    private int status;
    private List<String> errors;

    public ValidationErrorResponse(LocalDateTime timestamp, int status, List<String> errors) {
        this.timestamp = timestamp;
        this.status = status;
        this.errors = errors;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public List<String> getErrors() {
        return errors;
    }
}
