package com.example.apigenerator.model;


import com.example.apigenerator.Enum.Categoria;
import com.example.apigenerator.Enum.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "tarefa", nullable = false, unique = true)
    private String tarefa;

    @Column(name = "status")
    private Status status = Status.EM_ABERTO;

    @Column(name = "categoria")
    private Categoria categoria = Categoria.SEM_CATEGORIA;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
