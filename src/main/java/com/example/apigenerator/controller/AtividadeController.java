package com.example.apigenerator.controller;

import com.example.apigenerator.service.exception.AtividadeNotFoundException;
import com.example.apigenerator.model.Atividade;
import com.example.apigenerator.service.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/api/tasks")
public class AtividadeController {

    @Autowired
    AtividadeService atividadeService;

   //não tem necessidade de instanciar o repository aqui

    @GetMapping
    public ResponseEntity<List<Atividade>> mostrarTodasAtividades() throws AtividadeNotFoundException {
       List<Atividade> listAtividade = atividadeService.mostrarTodasAtividades();
        return ResponseEntity.ok().body(listAtividade);

    }
        //Melhoria: atividade deixa de ser um optional e passa a ter um tratamento de erro direto
    @GetMapping(value = "/{id}")
    public ResponseEntity<Atividade> buscarAtividadePorId(@PathVariable Long id) {
       Atividade atividade = atividadeService.buscarAtividadePorId(id)
                .orElseThrow(() -> new AtividadeNotFoundException("Atividade não encontrada"));
        return ResponseEntity.ok().body(atividade);

    }
    //sai a repetição de código de (value: "/tasks" onde nao tem necessidade)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Atividade> cadastrarAtividade(@RequestBody Atividade atividade) {
        atividade = atividadeService.cadastrarAtividade(atividade);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(atividade.getId()).toUri();
        return ResponseEntity.created(uri).body(atividade);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Atividade> alterarAtividade(@PathVariable Long id, @RequestBody Atividade atividade) {
        Atividade result = atividadeService.alterarAtividade(atividade, id);
        return ResponseEntity.ok(result);
    }

    @PatchMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Atividade> atualizarAtividade(@PathVariable Long id, @RequestBody Atividade atividade){
        Atividade resultado = atividadeService.update(atividade, id).getBody();
        return ResponseEntity.ok().body(resultado);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deletarAtividade(@PathVariable Long id) {
        atividadeService.deletarAtividade(id);
        return ResponseEntity.noContent().build();
    }

}