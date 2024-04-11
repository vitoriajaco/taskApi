package com.example.apigenerator.service;


import com.example.apigenerator.service.exception.AtividadeNotFoundException;
import com.example.apigenerator.exception.AtividadeSameIdException;
import com.example.apigenerator.model.Atividade;
import com.example.apigenerator.repository.AtividadeRepository;

import com.example.apigenerator.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;


    public List<Atividade> mostrarTodasAtividades()   {
        List<Atividade> atividades = atividadeRepository.findAll();

        if (atividades.isEmpty()){
            throw new ResourceNotFoundException("Ainda não há atividades cadastradas!");
        }


        return atividades;
    }

    public Optional<Atividade> buscarAtividadePorId(Long id) {
        return atividadeRepository.findById(id);
    }

    public Atividade cadastrarAtividade(Atividade atividade) {
        return atividadeRepository.save(atividade);
    }
    public Atividade alterarAtividade(Atividade atividade, Long id)  {
        if (!(atividade.getId() == id)) {
            throw new AtividadeSameIdException("ID de atividades não são iguais");
        }
        validadeSeAtividadeExiste(id);
        return atividadeRepository.save(atividade);
    }

    public ResponseEntity<Atividade> update(Atividade atividade, Long id) {
        return atividadeRepository.findById(id)
                .map(atividadeToUpdate -> {
                    atividadeToUpdate.setTarefa(atividade.getTarefa());
                    atividadeToUpdate.setStatus(atividade.getStatus());
                    Atividade updated = atividadeRepository.save(atividadeToUpdate);
                    return ResponseEntity.ok().body(updated);
                }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task não encontrada!"));
    }
    public void deletarAtividade(Long id){
        atividadeRepository.deleteById(id);
    }
    public Atividade validadeSeAtividadeExiste(Long id)  {
        Optional <Atividade> isPresent = atividadeRepository.findById(id);
        return isPresent.orElseThrow(() -> new AtividadeNotFoundException( "Atividade não encontrada!"));

        }

}
