package com.accenture.crud.domain.entity.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LivroCaixaDTO {

    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataLancamento;

    private String tipo;

    private Double valor;

    private Double saldo;
}
