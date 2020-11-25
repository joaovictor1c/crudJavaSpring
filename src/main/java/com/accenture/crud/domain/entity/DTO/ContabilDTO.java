package com.accenture.crud.domain.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContabilDTO {
    private Integer id;
    private String nome;
    private String cpfCpnj;
    private String telefone;

    private List<LivroCaixaDTO> contabil = new ArrayList<>();


}
