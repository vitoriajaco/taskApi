package com.example.apigenerator.service.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AtividadeNotFoundException extends RuntimeException {
    public  AtividadeNotFoundException (String message){
        super(message);
    }

}
