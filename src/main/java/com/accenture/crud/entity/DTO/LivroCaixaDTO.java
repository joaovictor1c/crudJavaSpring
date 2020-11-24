package com.accenture.crud.entity.DTO;

import com.accenture.crud.entity.LivroCaixa;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Column;

@Data
public class LivroCaixaDTO extends LivroCaixa {

    private Double saldo;
}
