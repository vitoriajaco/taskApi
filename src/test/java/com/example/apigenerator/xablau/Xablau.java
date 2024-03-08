package com.example.apigenerator.xablau;

import com.example.apigenerator.Enum.Categoria;
import com.example.apigenerator.Enum.Status;
import com.example.apigenerator.model.Atividade;
import com.example.apigenerator.repository.AtividadeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;




@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class Xablau {




        @Autowired
        private MockMvc mockMvc;
        @Autowired
        private AtividadeRepository atividadeRepository;
        @Autowired
        private ObjectMapper objectMapper;



        @Test
        @DisplayName("Deve cadastrar atividade passando todos os parametros")
        void deveCadastrarAtividade() throws Exception {
                Atividade atividade = new Atividade("Correr", Status.EXECUTANDO, Categoria.TRABALHO);

                String atividadeMapper = objectMapper.writeValueAsString(atividade);

                var result = mockMvc.perform(MockMvcRequestBuilders.post("/api/task/cadastrarAtividade")
                        .content(atividadeMapper).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.tarefa").value("Correr")).
                        andExpect(MockMvcResultMatchers.jsonPath("$.status").value("EXECUTANDO"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.categoria").value("TRABALHO"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L));

        }

        @Test
        @DisplayName("Deve cadastrar atividade somente com tarefa e retornar os valores default")
        void deveCadastrarAtividadeTest2() throws Exception {
                Atividade atividade = new Atividade("Caminhar");

                String atividadeMapper = objectMapper.writeValueAsString(atividade);

                var result = mockMvc.perform(MockMvcRequestBuilders.post("/api/task/cadastrarAtividade")
                                .content(atividadeMapper).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.tarefa").value("Caminhar")).
                        andExpect(MockMvcResultMatchers.jsonPath("$.status").value("EM_ABERTO"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.categoria").value("SEM_CATEGORIA"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L));

        }

        @Test
        @DisplayName("Deve alterar atividade")
        void DeveAlterarAtividade() throws Exception {
                Atividade atividade = new Atividade("Caminhar 5K", Status.EXECUTANDO, Categoria.PESSOAL);

                atividade.setTarefa("Caminhar");

                String atividadeMapper = objectMapper.writeValueAsString(atividade);

                var result = mockMvc.perform(MockMvcRequestBuilders.post("/api/task/cadastrarAtividade")
                                .content(atividadeMapper).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.tarefa").value("Caminhar")).
                        andExpect(MockMvcResultMatchers.jsonPath("$.status").value("EXECUTANDO"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.categoria").value("PESSOAL"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L));

        }

    }
