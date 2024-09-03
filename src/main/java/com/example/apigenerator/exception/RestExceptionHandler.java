package com.example.apigenerator.exception;

import com.example.apigenerator.service.exception.AtividadeNotFoundException;

import com.example.apigenerator.service.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AtividadeNotFoundException.class)
    private ResponseEntity<String> atividadeNotFoundHandler(AtividadeNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Atividade não pôde ser encontrada");
    }

    @ExceptionHandler(AtividadeSameIdException.class)
    private ResponseEntity<String> atividadeSameIdHandler(AtividadeSameIdException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Campo id de json e path não são correspondentes");
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    private ResponseEntity<String> atividadeNaoCadastradaHandler(ResourceNotFoundException exception){
        return ResponseEntity.status(HttpStatus.OK).body("Não há nenhuma atividade cadastrada");
    }



}

