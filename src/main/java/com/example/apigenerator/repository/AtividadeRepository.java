package com.example.apigenerator.repository;

import com.example.apigenerator.Enum.Categoria;
import com.example.apigenerator.model.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {
    List<Atividade> findByCategoria (Categoria categoria);

}



