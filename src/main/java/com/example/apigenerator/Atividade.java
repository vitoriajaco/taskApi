package com.example.apigenerator;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "tarefa", nullable = false, unique = true)
    private String tarefa;

    @Column(name = "status")
    private Status status = Status.EM_ABERTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
