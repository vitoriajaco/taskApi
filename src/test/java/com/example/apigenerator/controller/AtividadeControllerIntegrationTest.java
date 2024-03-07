package com.example.apigenerator.controller;



import com.example.apigenerator.Enum.Categoria;
import com.example.apigenerator.Enum.Status;
import com.example.apigenerator.model.Atividade;
import com.example.apigenerator.repository.AtividadeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")

public class AtividadeControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private AtividadeRepository atividadeRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        this.atividadeRepository.deleteAll();
    }

    @Test
    void deveCadastrarAtividade() throws Exception {
        Atividade atividade = new Atividade("Estudar teste de integração", Status.EXECUTANDO, Categoria.TRABALHO);

        String atividadeMapper = objectMapper.writeValueAsString(atividade);

       MockHttpServletRequestBuilder request = post("/cadastrarAtividade").contentType(MediaType.APPLICATION_JSON)
               .content(atividadeMapper);

       mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk());

               //(MockMvcResultMatchers.redirectedUrlPattern("http://localhost:8080/api/task/cadastrarAtividade"));

        List<Atividade> atividades = atividadeRepository.findAll();

        assertEquals(1, atividades.size());
    }


}
