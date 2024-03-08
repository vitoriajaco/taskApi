package com.example.apigenerator.model;


import com.example.apigenerator.Enum.Categoria;
import com.example.apigenerator.Enum.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity

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

    public Atividade(String tarefa, Status status, Categoria categoria) {
        this.tarefa = tarefa;
        this.status = status;
        this.categoria = categoria;
    }
    public Atividade(String tarefa) {
        this.tarefa = tarefa;

    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
