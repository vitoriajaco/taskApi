package com.example.apigenerator;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/task")
public class AtividadeController {

    @Autowired
    AtividadeService atividadeService;

    @GetMapping(path = "/listarAtividades")
    public List<Atividade> mostrarTodasAtividades(){
        return atividadeService.mostrarTodasAtividades();

    }

  /*  @GetMapping(path = "/listarAtividade/{status}")
    public List<Atividade> mostrarAtividadePorStatus(@PathVariable Status status){
        return atividadeService.mostrarPorStatus(status);

    }*/

    @GetMapping(path = "/buscarPorId/{id}")
    public Optional<Atividade> buscarAtividadePorId(@PathVariable Long id){
        return atividadeService.buscarAtividadePorId(id);

    }

    @PostMapping(path= "/cadastrarAtividade")
    @ResponseStatus(HttpStatus.CREATED)
    public Atividade cadastrarAtividade (@RequestBody Atividade atividade){
        return atividadeService.cadastrarAtividade(atividade);
    }

    @PutMapping(path="/alterarAtividade/{id}")
    public Atividade alterarAtividade (@PathVariable Long id, @RequestBody Atividade atividade){
        return atividadeService.alterarAtividade(atividade, id);
    }


    @DeleteMapping(path = "/DeletarAtividade/{id}")
    public void deletarAtividade (@PathVariable Long id){
        atividadeService.deletarAtividade(id);
    }
}

