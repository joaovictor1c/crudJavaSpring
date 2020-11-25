package com.accenture.crud.domain.repository;

import com.accenture.crud.domain.entity.Cliente;

import java.util.List;


public interface ClienteRepositoryQueries {
    List<Cliente> pesquisa(String nome, String cpfCnpj, String cidade, String uf);
}
