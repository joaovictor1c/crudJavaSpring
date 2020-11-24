package com.accenture.crud.repository;

import com.accenture.crud.entity.Cliente;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ClienteRepositoryQueries {
    List<Cliente> pesquisa(String nome, String cpfCnpj, String cidade, String uf);
}
