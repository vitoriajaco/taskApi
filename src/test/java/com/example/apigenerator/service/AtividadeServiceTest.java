package com.example.apigenerator.service;

import com.example.apigenerator.Enum.Categoria;
import com.example.apigenerator.Enum.Status;
import com.example.apigenerator.service.exception.AtividadeNotFoundException;
import com.example.apigenerator.exception.AtividadeSameIdException;
import com.example.apigenerator.model.Atividade;
import com.example.apigenerator.repository.AtividadeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/*class AtividadeServiceTest {

    @InjectMocks
    AtividadeService atividadeService;

    @Mock
    @Autowired
    AtividadeRepository atividadeRepository;

    private Atividade atividade;

    @Mock
    private AtividadeNotFoundException atividadeNotFoundException;

    //Verificar a necessidade do uso do final e static
    public static final Long ID = 1L;

    public static final String tarefa = "Iniciar estudos Java";

    public static final Status status = Status.EXECUTANDO;

    public static final Categoria categoria = Categoria.TRABALHO;


    private void iniciarAtividade() {
        atividade = new Atividade(tarefa, status, categoria);
    }


    @BeforeEach
    private void setUpAtividadeService() {
        MockitoAnnotations.openMocks(this);
        iniciarAtividade();

    }

    @Test
    void deveMostrarTodasAtividades() {
        List<Atividade> listaDeAtividades = new ArrayList<>();
        Atividade atividade2 = new Atividade("Correr uma maratona", Status.EM_ABERTO, Categoria.PESSOAL);
        Atividade atividade3 = new Atividade("Comprar batata doce", Status.CONCLUIDA, Categoria.MERCADO);
        listaDeAtividades.add(atividade);
        listaDeAtividades.add(atividade2);
        listaDeAtividades.add(atividade3);

        Mockito.when(atividadeRepository.findAll()).thenReturn(listaDeAtividades);

        List<Atividade> result = atividadeService.mostrarTodasAtividades();

        Assertions.assertEquals(result, listaDeAtividades);
        Assertions.assertNotNull(result);

    }*/

  /*  @Test
    void deveBuscarAtividadePorId() {

        Long atividadeIdMock = 1L;
        Mockito.when(atividadeRepository.findById(anyLong())).thenReturn(Optional.of(atividade));

       Atividade result = atividadeService.buscarAtividadePorId(atividadeIdMock);

        Assertions.assertEquals(atividade, result.get());


    }*/

/*    @Test
    void deveCadastrarAtividade() {

        Mockito.when(atividadeRepository.save(any())).thenReturn(atividade);

        Atividade result = atividadeService.cadastrarAtividade(atividade);

        Assertions.assertEquals(atividade, result);
        Assertions.assertNotNull(result);

    }*/

//    @Test
//    void deveAlterarAtividade() {
//
//
//        atividade.getId();
//        atividade.setTarefa("Estudar NodeJS");
//        atividade.setStatus(Status.CONCLUIDA);
//        atividade.setCategoria(Categoria.URGENTE);
//
//        Mockito.when(atividadeRepository.findById(anyLong())).thenReturn(Optional.of(atividade));
//        Mockito.when(atividadeRepository.save(atividade)).thenReturn(atividade);
//
//        Atividade result = atividadeService.alterarAtividade(atividade, 1L);
//
//        Assertions.assertEquals(atividade, result);
//        Assertions.assertNotNull(result);
//
//    }

//    @Test
//    void deveRetornarExceptionDeIDDiferentes() {
//
//        Mockito.when(atividadeRepository.findById(anyLong())).thenReturn(Optional.of(atividade));
//
//        Assertions.assertThrows(AtividadeSameIdException.class, () -> {
//            Atividade result = atividadeService.alterarAtividade(atividade, 2L);
//        }, "ID de atividades não são iguais");
//
//    }

/*    @Test
    void update() {

        Mockito.when(atividadeRepository.findById(anyLong())).thenReturn(Optional.of(atividade));
        atividade.getId();
        atividade.setTarefa("Comprar brocolis");
        atividade.setStatus(Status.EM_ABERTO);
        atividade.setCategoria(Categoria.MERCADO);

        Mockito.when(atividadeRepository.save(atividade)).thenReturn(atividade);

        //ResponseEntity<Atividade> result = atividadeService.update(atividade, ID);

        Assertions.assertNotNull(atividade);
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals(atividade, result.getBody());

    }

    @Test
    void deveRetornarExceptionTaskNaoEncontrada() {
        Atividade atividadeVazia = new Atividade();

        Mockito.when(atividadeRepository.findById(anyLong())).thenReturn(Optional.empty());


        Assertions.assertThrows(ResponseStatusException.class, () -> {
            ResponseEntity result = atividadeService.update(atividadeVazia, 2L);
        }, "Task não encontrada!");


    }
}*/

 /*   @Test
    void deveDeletarAtividade() {
        atividadeService.deletarAtividade(1L);

        Mockito.verify(atividadeRepository, Mockito.times(1)).deleteById(atividade.getId());
    }*/

/*
    @Test
    void validaSeAtividadeExiste(){

       when(atividadeRepository.findById(anyLong())).thenReturn(Optional.empty());

        Assertions.assertThrows(AtividadeNotFoundException.class, () -> {
           var result = atividadeService.validarSeAtividadeExiste(2L);
        }, "Atividade não encontrada!");
    }
}*/
