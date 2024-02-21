package com.example.apigenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    public List<Atividade> mostrarTodasAtividades(){
        return atividadeRepository.findAll();
    }
    public Optional<Atividade> buscarAtividadePorId(Long id){
        return atividadeRepository.findById(id);
    }

    public Atividade cadastrarAtividade(Atividade atividade){
        atividade.getId();
        atividade.getTarefa();
        atividade.getStatus();
        return atividadeRepository.save(atividade);
    }

    public Atividade alterarAtividade(Atividade atividade){
        atividade.getId();
        atividade.setTarefa(atividade.getTarefa());
        atividade.setStatus(atividade.getStatus());
        return atividadeRepository.save(atividade);
    }
    public void deletarAtividade(Long id){
        atividadeRepository.deleteById(id);
    }

}
