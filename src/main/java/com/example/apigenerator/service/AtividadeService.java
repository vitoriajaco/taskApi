package com.example.apigenerator.service;


import com.example.apigenerator.Enum.Categoria;
import com.example.apigenerator.Enum.Status;

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
            validarSeAtividadeExiste(id);

        return atividadeRepository.findById(id);
    }

    public List<Atividade> buscarPorCategoria(Categoria categoria){
        return atividadeRepository.findByCategoria(categoria);
    }

    public Atividade cadastrarAtividade(Atividade atividade) {
        return atividadeRepository.save(atividade);
    }
    public Atividade alterarAtividade(Atividade atividade, Long id)  {
        if (!(atividade.getId().equals(id))) { // aqui tinha um == id -> substitui por equals
            throw new AtividadeSameIdException("ID de atividades não são iguais");
        }
        validarSeAtividadeExiste(id);
        return atividadeRepository.save(atividade);
    }


    public ResponseEntity<Atividade> atualizarAtividade(Atividade atividade, Long id) {
        return atividadeRepository.findById(id)
                .map(atividadeToUpdate -> {

                    if (atividade.getTarefa() != null) {
                        atividadeToUpdate.setTarefa(atividade.getTarefa());
                    }

                    if (atividade.getStatus() != Status.EM_ABERTO) {
                        atividadeToUpdate.setStatus(atividade.getStatus());
                    }


                    if (atividade.getCategoria() != Categoria.SEM_CATEGORIA) {
                        atividadeToUpdate.setCategoria(atividade.getCategoria());
                    }

                    Atividade updated = atividadeRepository.save(atividadeToUpdate);
                    return ResponseEntity.ok().body(updated);
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task não encontrada!"));
    }

                    public void deletarAtividade(Long id){
                        validarSeAtividadeExiste(id);
                        atividadeRepository.deleteById(id);
                    }

                    public void validarSeAtividadeExiste(Long id){
                        if (!atividadeRepository.existsById(id)) {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Atividade com id" + id + "não encontrada");
                        }
    }
}