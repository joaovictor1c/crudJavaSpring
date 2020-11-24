package com.accenture.crud.entity.DTO;

import lombok.Data;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Data
public class ContabilDTO {
    private Integer id;
    private String nome;
    private String cpfCpnj;
    private String telefone;

    private List<LivroCaixaDTO> contabil = new ArrayList<>();


}
