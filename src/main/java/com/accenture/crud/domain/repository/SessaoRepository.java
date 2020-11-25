package com.accenture.crud.domain.repository;

import com.accenture.crud.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByLogin(String login);
}
