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
    public ResponseEntity<List<Atividade>> mostrarTodasAtividades() {
        return ResponseEntity.ok(atividadeService.mostrarTodasAtividades());

    }

    @GetMapping(path = "/buscarPorId/{id}")
    public ResponseEntity<Optional<Atividade>> buscarAtividadePorId(@PathVariable Long id) {
        return ResponseEntity.ok(atividadeService.buscarAtividadePorId(id));

    }

    @PostMapping(path = "/cadastrarAtividade")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Atividade> cadastrarAtividade(@RequestBody Atividade atividade) {
        return ResponseEntity.ok(atividadeService.cadastrarAtividade(atividade));
    }

    @PutMapping(path = "/alterarAtividade/{id}")
    public ResponseEntity<Atividade> alterarAtividade(@PathVariable Long id, @RequestBody Atividade atividade) {
        Atividade result = atividadeService.alterarAtividade(atividade, id);
        return ResponseEntity.ok(result);
    }

    @PutMapping(path = "/updateAtividade/{id}")
    public ResponseEntity<Atividade> updateTask(@PathVariable Long id, @RequestBody Atividade atividade){
        Atividade resultado = atividadeService.update(atividade, id).getBody();
        return ResponseEntity.ok(resultado);
    }

    @DeleteMapping(path = "/DeletarAtividade/{id}")
    public ResponseEntity<Boolean> deletarAtividade(@PathVariable Long id) {
        atividadeService.deletarAtividade(id);
        return ResponseEntity.ok(true);
    }

    public Optional<Atividade> buscarPorId(@PathVariable Long id) {
        return atividadeRepository.findById(id);

    }

}