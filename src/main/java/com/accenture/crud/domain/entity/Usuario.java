package com.accenture.crud.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro = LocalDate.now();

    @Column(length = 30)

    private String nome;

    @Column(length = 15, unique = true)
    @NotNull
    private String login;

    @Column(length = 10)
    @NotNull
    private String senha;

    @Column(length = 11)
    private String telefone;

    @Column(length = 100)
    private String email;

    @Column(length = 1)
    @NotNull
    private String perfil;

    @Column(length = 1)
    @NotNull
    private String status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id &&
                Objects.equals(login, usuario.login) &&
                Objects.equals(status, usuario.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, status);
    }
}
