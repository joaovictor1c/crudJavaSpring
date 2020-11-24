package com.accenture.crud.repository;

import com.accenture.crud.entity.Cliente;
import com.accenture.crud.entity.LivroCaixa;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroCaixaRepository extends JpaRepository<LivroCaixa, Integer> {

    List<LivroCaixa> findByCliente(Integer id);
}
