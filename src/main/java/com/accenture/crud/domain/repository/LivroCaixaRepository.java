package com.accenture.crud.domain.repository;

import com.accenture.crud.domain.entity.LivroCaixa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LivroCaixaRepository extends JpaRepository<LivroCaixa, Integer> {

    List<LivroCaixa> findByClienteId(Integer id);

    List<LivroCaixa> findByClienteIdAndDataLancamentoBetween(int id, Date start, Date end);
}
