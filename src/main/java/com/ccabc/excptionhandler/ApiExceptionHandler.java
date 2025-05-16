package com.ccabc.excptionhandler;

import com.ccabc.payload.ApiExceptionPayload;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ApiExceptionPayload> handleAPIException(Exception exception, WebRequest webRequest) {
        String path = webRequest.getDescription(false);

        // Creating the payload
        ApiExceptionPayload apiExceptionPayload = new ApiExceptionPayload();
        apiExceptionPayload.setMessage(exception.getMessage());
        apiExceptionPayload.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        apiExceptionPayload.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        apiExceptionPayload.setSuccess(false);
        apiExceptionPayload.setException(true);
        apiExceptionPayload.setTimestamp(java.time.LocalDateTime.now());
        apiExceptionPayload.setPath(path);

        // Returning the payload
        return new ResponseEntity<>(apiExceptionPayload, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
