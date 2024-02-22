package com.example.apigenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;


    public List<Atividade> mostrarTodasAtividades() {
        return atividadeRepository.findAll();
    }

    /*  public List<Atividade> mostrarPorStatus(Status status){
         var x = atividadeRepository.findBy(Status.CONCLUIDA);
          return mostrarPorStatus(status);
      }*/
    public Optional<Atividade> buscarAtividadePorId(Long id) {
        return atividadeRepository.findById(id);
    }

    public Atividade cadastrarAtividade(Atividade atividade) {
        atividade.getId();
        atividade.getTarefa();
        atividade.getStatus();
        return atividadeRepository.save(atividade);
    }

    //Ponto a melhorar
    public Atividade alterarAtividade(Atividade atividade, Long id) {
        if (!(atividade.getId() == id)) {
            throw new AtividadeSameIdException("ID de atividades não são iguais");
        }
       validadeSeAtividadeExiste(id);
      return atividadeRepository.save(atividade);

    }

    //PARTE ANTIGA
/*    public Atividade alterarAtividade(Atividade atividade, Long id){
        atividade.getId();
        atividade.setTarefa(atividade.getTarefa());
        atividade.setStatus(atividade.getStatus());
        return atividadeRepository.save(atividade);
    }*/
    public void deletarAtividade(Long id){
        atividadeRepository.deleteById(id);
    }

    private Atividade validadeSeAtividadeExiste(Long id){
        Optional <Atividade> isPresent = atividadeRepository.findById(id);
        return isPresent.orElseThrow(() -> new AtividadeNotFoundException("Atividade não encontrada!"));

        }

}
