package com.example.apigenerator.controller;

import com.example.apigenerator.model.Atividade;
import com.example.apigenerator.repository.AtividadeRepository;
import com.example.apigenerator.service.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/task")
public class AtividadeController {

    @Autowired
    AtividadeService atividadeService;

    @Autowired
    private AtividadeRepository atividadeRepository;

    @GetMapping(path = "/listarAtividades")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<List<Atividade>> mostrarTodasAtividades() {
        return ResponseEntity.ok(atividadeService.mostrarTodasAtividades());

    }

    @GetMapping(path = "/buscarPorId/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<Optional<Atividade>> buscarAtividadePorId(@PathVariable Long id) {
        return ResponseEntity.ok(atividadeService.buscarAtividadePorId(id));

    }

    @PostMapping(path = "/cadastrarAtividade")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Atividade> cadastrarAtividade(@RequestBody Atividade atividade) {
       Atividade create = atividadeService.cadastrarAtividade(atividade);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(path = "/alterarAtividade/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Atividade> alterarAtividade(@PathVariable Long id, @RequestBody Atividade atividade) {
        Atividade result = atividadeService.alterarAtividade(atividade, id);
        return ResponseEntity.ok(result);
    }

    @PutMapping(path = "/updateAtividade/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Atividade> updateTask(@PathVariable Long id, @RequestBody Atividade atividade){
        Atividade resultado = atividadeService.update(atividade, id).getBody();
        return ResponseEntity.ok(resultado);
    }

    @DeleteMapping(path = "/DeletarAtividade/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Atividade> deletarAtividade(@PathVariable Long id) {
        atividadeService.deletarAtividade(id);
        return (ResponseEntity<Atividade>) ResponseEntity.noContent();
    }


}