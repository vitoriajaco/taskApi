package com.example.apigenerator.service;

import com.example.apigenerator.Enum.Status;
import com.example.apigenerator.exception.AtividadeNotFoundException;
import com.example.apigenerator.exception.AtividadeSameIdException;
import com.example.apigenerator.model.Atividade;
import com.example.apigenerator.repository.AtividadeRepository;
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

    public ResponseEntity<Atividade> update(Atividade atividade, Long id) {
        return atividadeRepository.findById(id)
                .map(atividadeToUpdate -> {
                    atividadeToUpdate.setTarefa(atividade.getTarefa());
                    atividadeToUpdate.setStatus(atividade.getStatus());
                    Atividade updated = atividadeRepository.save(atividadeToUpdate);
                    return ResponseEntity.ok().body(updated);
                }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task não encontrada!")); //.orElseThrow(ResponseEntity.notFound().build()); -> Verificar pq nao aceitou
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

  /*  private Atividade findByStatus (Status status){

    }*/

}
