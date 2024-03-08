package com.example.apigenerator.repository;


import com.example.apigenerator.Enum.Categoria;
import com.example.apigenerator.Enum.Status;
import com.example.apigenerator.controller.AtividadeController;
import com.example.apigenerator.model.Atividade;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.Optional;

@DataJpaTest

public class AtividadeRepositoryIntegrationTest {

    @Autowired
    private AtividadeRepository atividadeRepository;


    @Test
    @Transactional //garante que as alterações sejam revertidas após cada teste
    public void deveRetornarObjetoSalvo(){

        Atividade atividade = new Atividade();

        atividade.setTarefa("Estudar testes de integração");
        atividade.setStatus(Status.EXECUTANDO);
        atividade.setCategoria(Categoria.TRABALHO);

        Atividade salvarAtividade = atividadeRepository.save(atividade);

        Atividade verificaRetornoDaAtividade = atividadeRepository.findById(salvarAtividade.getId()).orElse(null);

        Assertions.assertNotNull(verificaRetornoDaAtividade);
        Assertions.assertEquals(atividade.getStatus(), verificaRetornoDaAtividade.getStatus());
        Assertions.assertEquals(atividade.getTarefa(), verificaRetornoDaAtividade.getTarefa());
        Assertions.assertEquals(atividade.getCategoria(), verificaRetornoDaAtividade.getCategoria());
        Assertions.assertEquals(atividade.getId(), verificaRetornoDaAtividade.getId());

    }
    @Test
    @Transactional
    public void deveCadastrarAtividadeSemStatusECategoriaERetornarValoresDefault(){

        Atividade atividade = new Atividade();
        atividade.setTarefa("Estudar Spring Boot");

        Atividade salvarAtividade = atividadeRepository.save(atividade);

        Atividade verificaRetornoDaAtividade = atividadeRepository.findById(salvarAtividade.getId()).orElse(null);

        Assertions.assertNotNull(verificaRetornoDaAtividade);
        Assertions.assertEquals(atividade.getStatus(), verificaRetornoDaAtividade.getStatus());
        Assertions.assertEquals(atividade.getTarefa(), verificaRetornoDaAtividade.getTarefa());
        Assertions.assertEquals(atividade.getCategoria(), verificaRetornoDaAtividade.getCategoria());
        Assertions.assertEquals(atividade.getId(), verificaRetornoDaAtividade.getId());


    }

    @Test
    @Transactional
    public void deveAtualizarAtividade(){

        Atividade atividade = new Atividade( "Estudar testes unitarios", Status.CONCLUIDA, Categoria.PESSOAL);

        atividade.setTarefa("Estudar CloudWatch");
        atividade.setStatus(Status.EXECUTANDO);

        Atividade salvarAtividade = atividadeRepository.save(atividade);

        Atividade verificaRetorno = atividadeRepository.findById(atividade.getId()).orElse(null);

        Assertions.assertNotNull(verificaRetorno);
        Assertions.assertEquals(atividade.getTarefa(), salvarAtividade.getTarefa());
        Assertions.assertEquals(atividade.getId(), salvarAtividade.getId());
        Assertions.assertEquals(atividade.getCategoria(), salvarAtividade.getCategoria());
        Assertions.assertEquals(atividade.getStatus(), verificaRetorno.getStatus());

    }
    @Test
    public void deveDeletarAtividade(){


        AtividadeController atividadeController = new AtividadeController();

        Atividade atividade = new Atividade( "Estudar testes unitarios", Status.CONCLUIDA, Categoria.PESSOAL);

        Atividade salvarAtividade = atividadeRepository.save(atividade);


        Optional<Atividade> apagarAtividade = atividadeRepository.findById(atividade.getId());

        atividadeController.deletarAtividade(apagarAtividade.get().getId());











    }
}
