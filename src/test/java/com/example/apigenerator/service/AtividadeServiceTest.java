package com.example.apigenerator.service;

import com.example.apigenerator.Enum.Categoria;
import com.example.apigenerator.Enum.Status;
import com.example.apigenerator.exception.AtividadeNotFoundException;
import com.example.apigenerator.model.Atividade;
import com.example.apigenerator.repository.AtividadeRepository;
import com.example.apigenerator.repository.AtividadeRepositoryTest;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    public static final String atividadeNaoEncontradaError = "Atividade não encontrada!";


    private void iniciarAtividade(){
        atividade = new Atividade(ID,tarefa, status, categoria);
    }


    @BeforeEach
    private void setAtividadeService(){
        MockitoAnnotations.openMocks(this);
        iniciarAtividade();

    }

    @Test
    void deveMostrarTodasAtividades() {
        List<Atividade>listaDeAtividades = new ArrayList<>();
        Atividade atividade2 = new Atividade(2L, "Correr uma maratona", Status.EM_ABERTO, Categoria.PESSOAL);
        Atividade atividade3 = new Atividade(3L, "Comprar batata doce", Status.CONCLUIDA, Categoria.MERCADO);
        listaDeAtividades.add(atividade);
        listaDeAtividades.add(atividade2);
        listaDeAtividades.add(atividade3);

        Mockito.when(atividadeRepository.findAll()).thenReturn(listaDeAtividades);

        List<Atividade> result = atividadeService.mostrarTodasAtividades();

        Assertions.assertEquals(result, listaDeAtividades);
        Assertions.assertNotNull(result);

    }

    @Test
    void deveBuscarAtividadePorId() {

        Long atividadeIdMock = 1L;
        Mockito.when(atividadeRepository.findById(anyLong())).thenReturn(Optional.of(atividade));

        Optional<Atividade> result = atividadeService.buscarAtividadePorId(atividadeIdMock);

       Assertions.assertEquals(result.get(), atividade);


    }

    @Test
    void deveCadastrarAtividade() {

        Mockito.when(atividadeRepository.save(any())).thenReturn(atividade);

        Atividade result = atividadeService.cadastrarAtividade(atividade);

        Assertions.assertEquals(result, atividade);
        Assertions.assertNotNull(result);

    }

    @Test
    void alterarAtividade() {


        atividade.getId();
        atividade.setTarefa("Estudar NodeJS");
        atividade.setStatus(Status.CONCLUIDA);
        atividade.setCategoria(Categoria.URGENTE);

        Mockito.when(atividadeRepository.findById(anyLong())).thenReturn(Optional.of(atividade));
        Mockito.when(atividadeRepository.save(atividade)).thenReturn(atividade);

        Atividade result = atividadeService.alterarAtividade(atividade, 1L);

       Assertions.assertEquals(atividade, result);
       Assertions.assertNotNull(result);

    }

    @Test
    void update() {
    }

    @Test
    void deveDeletarAtividade() {
        atividadeService.deletarAtividade(1L);

        Mockito.verify(atividadeRepository, Mockito.times(1)).deleteById(atividade.getId());
    }

    @Test
    void validaSeAtividadeExiste(){
      //  when(atividadeRepository.findById(anyLong())).thenReturn(new AtividadeNotFoundException());
    }
}