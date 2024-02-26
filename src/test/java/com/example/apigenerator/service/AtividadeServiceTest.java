package com.example.apigenerator.service;

import com.example.apigenerator.Enum.Categoria;
import com.example.apigenerator.Enum.Status;
import com.example.apigenerator.model.Atividade;
import com.example.apigenerator.repository.AtividadeRepository;
import com.example.apigenerator.repository.AtividadeRepositoryTest;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;

class AtividadeServiceTest {

    @InjectMocks
    AtividadeService atividadeService;

    @Mock
    @Autowired
    AtividadeRepository atividadeRepository;

    private Atividade atividade;

    private Optional<Atividade> atividadeOptional;

    //Verificar a necessidade do uso do final e static
    public static final Long ID = 1L;

    public static final String tarefa = "Iniciar estudos Java";

    public static final Status status = Status.EXECUTANDO;

    public static final Categoria categoria = Categoria.TRABALHO;


    private void iniciarAtividade(){
        atividade = new Atividade(ID,tarefa, status, categoria);
    }


    @BeforeEach
    private void setAtividadeService(){
        MockitoAnnotations.openMocks(this);
        iniciarAtividade();

    }

    @Test
    void mostrarTodasAtividades() {
    }

    @Test
    void buscarAtividadePorId() {

        Long atividadeIdMock = 1L;
        Mockito.when(atividadeRepository.findById(anyLong())).thenReturn(Optional.of(atividade));

        Optional<Atividade> result = atividadeService.buscarAtividadePorId(atividadeIdMock);

       Assertions.assertEquals(result.get(), atividade);
        System.out.println(result.get());
        System.out.println(atividade);

    }

    @Test
    void cadastrarAtividade() {
    }

    @Test
    void alterarAtividade() {
    }

    @Test
    void update() {
    }

    @Test
    void deletarAtividade() {
    }
}