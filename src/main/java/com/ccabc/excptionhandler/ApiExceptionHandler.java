package com.ccabc.excptionhandler;

import com.ccabc.payload.ApiExceptionPayload;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ApiExceptionPayload> handleAPIException(ResponseStatusException exception, WebRequest webRequest){
        String path=webRequest.getDescription(true);

//        Creating the payload
        ApiExceptionPayload apiExceptionPayload=new ApiExceptionPayload();
        apiExceptionPayload.setMessage(exception.getReason());
        apiExceptionPayload.setStatusCode(exception.getStatusCode().value());
        apiExceptionPayload.setHttpStatus(exception.getStatusCode().toString());
        apiExceptionPayload.setSuccess(false);
        apiExceptionPayload.setException(true);
        apiExceptionPayload.setTimestamp(java.time.LocalDateTime.now());
        apiExceptionPayload.setPath(path);

//        Returning the payload
        return new ResponseEntity<>(apiExceptionPayload, exception.getStatusCode());
    }
}
