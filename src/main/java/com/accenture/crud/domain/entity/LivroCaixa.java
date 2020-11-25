package com.accenture.crud.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter

public class LivroCaixa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private int id;

    @Column
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataLancamento;

    @Column(length = 50)
    @NotNull
    private String descricao;

    @Column(length = 1)
    @NotNull
    private String tipo;

    @Column()
    @NotNull
    private Double valor;

    @ManyToOne
    @JsonIgnore
    private Cliente cliente;

    @JsonIgnore
    public Cliente getCliente() {
        return cliente;
    }

}
