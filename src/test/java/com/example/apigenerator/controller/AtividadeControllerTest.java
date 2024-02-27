package com.example.apigenerator.controller;

import com.example.apigenerator.Enum.Categoria;
import com.example.apigenerator.Enum.Status;
import com.example.apigenerator.model.Atividade;
import com.example.apigenerator.service.AtividadeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class AtividadeControllerTest {

    public static final Long ID = 1L;

    public static final String tarefa = "Iniciar estudos Java";

    public static final Status status = Status.EXECUTANDO;

    public static final Categoria categoria = Categoria.TRABALHO;

    private Atividade atividade;

    @InjectMocks
    private AtividadeController atividadeController;

    @Mock
    private AtividadeService atividadeService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        iniciarAtividade();
    }

    @Test
    void mostrarTodasAtividades() {
    }

    @Test
    void buscarAtividadePorId() {
    }

    @Test
    void cadastrarAtividade() {
        Mockito.when(atividadeService.cadastrarAtividade(any())).thenReturn(atividade);
        ResponseEntity<Atividade> result = atividadeController.cadastrarAtividade(atividade);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void alterarAtividade() {
    }

    @Test
    void updateTask() {
    }

    @Test
    void deletarAtividade() {
    }

    @Test
    void buscarPorId() {
    }

    public void iniciarAtividade(){
        atividade = new Atividade(ID,tarefa, status, categoria);
    }
}