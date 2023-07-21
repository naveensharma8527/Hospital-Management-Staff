package com.astroTalk.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PatientException.class)
    public ResponseEntity<ErrorDetails> myCustomerExceptionHandler(PatientException patientException, WebRequest req){

        ErrorDetails err = new ErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(patientException.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);

    }
}
