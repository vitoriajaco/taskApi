package com.example.apigenerator.controller;

import com.example.apigenerator.Enum.Categoria;
import com.example.apigenerator.Enum.Status;
import com.example.apigenerator.model.Atividade;
import com.example.apigenerator.repository.AtividadeRepository;
import com.example.apigenerator.service.AtividadeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@SpringBootTest
class AtividadeControllerTest {


//    public static final Long ID = 1L;
//
//    public static final String tarefa = "Iniciar estudos Java";
//
//    public static final Status status = Status.EXECUTANDO;
//
//    public static final Categoria categoria = Categoria.TRABALHO;
//
//    private Atividade atividade;
//
//    @Mock
//    private ResponseEntity<Atividade> responseEntityAtividade;
//
//    @InjectMocks
//    private AtividadeController atividadeController;
//    @Mock
//    private AtividadeService atividadeService;
//    @Autowired
//    @Mock
//    private AtividadeRepository atividadeRepository;
//
//
//    @BeforeEach
//    void setUp(){
//        MockitoAnnotations.openMocks(this);
//        iniciarAtividade();
//    }
//
//    @Test
//    void deveMostrarStatus200AoListarTodasAtividades() {
//        Mockito.when(atividadeService.mostrarTodasAtividades()).thenReturn(List.of(atividade));
//        ResponseEntity<List<Atividade>> result = atividadeController.mostrarTodasAtividades();
//
//        assertEquals(HttpStatus.OK, result.getStatusCode());
//        assertNotNull(result);
//
//    }
//
//    @Test
//    void aoBuscarAtividadePorIdDeveRetornarStatusOk() {
//        Mockito.when(atividadeService.buscarAtividadePorId(anyLong())).thenReturn(Optional.of(atividade));
//        ResponseEntity<Atividade>result = atividadeController.alterarAtividade(ID, atividade);
//
//        assertEquals(HttpStatus.OK, result.getStatusCode());
//        assertNotNull(result.getStatusCode());
//        assertNotNull(result);
//
//    }
//
//    @Test
//    void aoCadastrarAtividadeDeveRetornarStatusOk() {
//        Mockito.when(atividadeService.cadastrarAtividade(any())).thenReturn(atividade);
//        ResponseEntity<Atividade> result = atividadeController.cadastrarAtividade(atividade);
//        assertEquals(HttpStatus.OK, result.getStatusCode());
//    }
//
//    @Test
//    void aoAlterarAtividadeDeveRetornarStatusCodeOk() {
//        Mockito.when(atividadeService.alterarAtividade(any(), anyLong())).thenReturn(atividade);
//        ResponseEntity<Atividade> result = atividadeController.alterarAtividade(ID, atividade);
//
//        assertEquals(HttpStatus.OK, result.getStatusCode());
//        assertNotNull(result.getStatusCode());
//
//    }
//
//    @Test
//    void aoEditarAtividadeDeveRetornar200OKMetodoUpdate() {
//      atividade.getId();
//      atividade.setTarefa("Aprender Cobol");
//      atividade.getStatus();
//      atividade.getCategoria();
//
//
//
//      Mockito.when(atividadeService.update(any(), anyLong())).thenReturn(responseEntityAtividade);
//      Mockito.when(atividadeRepository.findById(anyLong())).thenReturn(Optional.of(atividade));
//      Mockito.when(atividadeRepository.save(atividade)).thenReturn(atividade);
//
//
//      ResponseEntity<Atividade> result = atividadeController.updateTask(ID, atividade);
//
//
//      Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
//      assertNotNull(result);
//
//
//    }
//
//    @Test
//    void deletarAtividadeERetornarStatusOK() {
//        Mockito.doNothing().when(atividadeService).deletarAtividade(anyLong());
//
//        ResponseEntity<?> result = atividadeController.deletarAtividade(ID);
//
//        assertNotNull(result);
//        Mockito.verify(atividadeService, Mockito.times(1)).deletarAtividade(anyLong());
//        assertEquals(HttpStatus.OK, result.getStatusCode() );
//    }
//
//    @Test
//    void buscarPorIdRetornandoStatusOK() {
//        Mockito.when(atividadeService.buscarAtividadePorId(anyLong())).thenReturn(Optional.of(atividade));
//       // ResponseEntity<Optional<Atividade>> result = atividadeController.buscarAtividadePorId(ID);
//
//      //  assertNotNull(result);
//       // assertEquals(HttpStatus.OK, result.getStatusCode());
//    }
//
//    public void iniciarAtividade(){
//        atividade = new Atividade(tarefa, status, categoria);
//    }

}