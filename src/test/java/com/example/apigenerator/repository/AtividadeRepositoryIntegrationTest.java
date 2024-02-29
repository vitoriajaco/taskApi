package com.example.apigenerator.repository;


import com.example.apigenerator.Enum.Categoria;
import com.example.apigenerator.Enum.Status;
import com.example.apigenerator.model.Atividade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class AtividadeRepositoryIntegrationTest {

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Test
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
}
