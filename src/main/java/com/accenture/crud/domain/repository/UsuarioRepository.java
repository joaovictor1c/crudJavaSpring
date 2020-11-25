package com.accenture.crud.domain.repository;

import com.accenture.crud.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findByNomeContains(String nome);
    List<Usuario> findByEmailContains(String email);
    List<Usuario> findByNomeContainsAndEmailContains(String nome,String email);
}
