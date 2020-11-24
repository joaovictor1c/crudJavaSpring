package com.accenture.crud.repository;

import com.accenture.crud.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByLogin(String login);
}
