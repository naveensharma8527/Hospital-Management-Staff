package com.astroTalk.exception;

public class PatientException extends RuntimeException{

    public PatientException() {

    }

    public PatientException(String message) {
        super(message);
    }
}
