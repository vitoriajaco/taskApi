package com.example.apigenerator.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class AtividadeSameIdException extends RuntimeException {
    public AtividadeSameIdException(String message) {
        super (message);
    }
}
