package com.accenture.crud.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @CreationTimestamp
    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataCadastro;

    @Column(length = 30)
    @NotNull
    private String nome;

    @Column(length = 14)
    @NotNull
    private String cpfCnpj;

    @Column(length = 50)
    @NotNull
    private String logradouro;

    @Column(length = 40)
    @NotNull
    private String cidade;

    @Column(length = 2)
    @NotNull
    private String uf;

    @Column(length = 8)
    @NotNull
    private String cep;

    @Column(length = 11)
    private String telefone;

    @Column(length = 100)
    private String email;
}
