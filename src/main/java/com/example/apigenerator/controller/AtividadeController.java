package com.example.apigenerator.controller;

import com.example.apigenerator.service.exception.AtividadeNotFoundException;
import com.example.apigenerator.model.Atividade;
import com.example.apigenerator.repository.AtividadeRepository;
import com.example.apigenerator.service.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class AtividadeController {

    @Autowired
    AtividadeService atividadeService;

    @Autowired
    private AtividadeRepository atividadeRepository;

    @GetMapping(value = "/task")
    public ResponseEntity<List<Atividade>> mostrarTodasAtividades() throws AtividadeNotFoundException {
       List<Atividade> listAtividade = atividadeService.mostrarTodasAtividades();
        return ResponseEntity.ok().body(listAtividade);

    }

    @GetMapping(value = "/task/{id}")
    public ResponseEntity<Optional<Atividade>> buscarAtividadePorId(@PathVariable Long id) {
        Optional<Atividade> atividade = atividadeService.buscarAtividadePorId(id);
        return ResponseEntity.ok().body(atividade);

    }

    @PostMapping(value = "/task")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Atividade> cadastrarAtividade(@RequestBody Atividade atividade) {
        atividade = atividadeService.cadastrarAtividade(atividade);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(atividade.getId()).toUri();
        return ResponseEntity.created(uri).body(atividade);
    }

    @PutMapping(value = "/tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Atividade> alterarAtividade(@PathVariable Long id, @RequestBody Atividade atividade) throws AtividadeNotFoundException {
        Atividade result = atividadeService.alterarAtividade(atividade, id);
        return ResponseEntity.ok(result);
    }

    @PutMapping(value = "/task/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Atividade> updateTask(@PathVariable Long id, @RequestBody Atividade atividade){
        Atividade resultado = atividadeService.update(atividade, id).getBody();
        return ResponseEntity.ok().body(resultado);
    }

    @DeleteMapping(value = "/task/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deletarAtividade(@PathVariable Long id) {
        atividadeService.deletarAtividade(id);
        return ResponseEntity.noContent().build();
    }


}