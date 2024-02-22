package com.example.apigenerator;

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

    @GetMapping(path = "/listarAtividades")
    public ResponseEntity<List<Atividade>> mostrarTodasAtividades(){
        return ResponseEntity.ok(atividadeService.mostrarTodasAtividades());

    }

  /*  @GetMapping(path = "/listarAtividade/{status}")
    public List<Atividade> mostrarAtividadePorStatus(@PathVariable Status status){
        return atividadeService.mostrarPorStatus(status);

    }*/

    @GetMapping(path = "/buscarPorId/{id}")
    public ResponseEntity<Optional<Atividade>> buscarAtividadePorId(@PathVariable Long id){
        return ResponseEntity.ok(atividadeService.buscarAtividadePorId(id));

    }

    @PostMapping(path= "/cadastrarAtividade")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Atividade> cadastrarAtividade (@RequestBody Atividade atividade){
        return ResponseEntity.ok(atividadeService.cadastrarAtividade(atividade));
    }

    @PutMapping(path="/alterarAtividade/{id}")
    public ResponseEntity<Atividade> alterarAtividade (@PathVariable Long id, @RequestBody Atividade atividade){
        Atividade result =  atividadeService.alterarAtividade(atividade, id);
        return ResponseEntity.ok(result);
    }


    @DeleteMapping(path = "/DeletarAtividade/{id}")
    public ResponseEntity<Boolean> deletarAtividade (@PathVariable Long id){
        atividadeService.deletarAtividade(id);
        return ResponseEntity.ok(true);
    }
}

