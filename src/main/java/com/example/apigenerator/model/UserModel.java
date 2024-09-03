package com.example.apigenerator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String nomeUsuario;

    private String password;

    @OneToMany(mappedBy = "nomeUsuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Atividade> ListaAtividade;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNome() {
        return nomeUsuario;
    }

    public void setNome(String nome) {
        this.nomeUsuario = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Atividade> getListaAtividade() {
        return ListaAtividade;
    }

    public void setListaAtividade(List<Atividade> listaAtividade) {
        ListaAtividade = listaAtividade;
    }

}
