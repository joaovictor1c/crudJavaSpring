package com.accenture.crud.repository;

import com.accenture.crud.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findByNomeContains(String nome);
    List<Usuario> findByEmailContains(String email);
    List<Usuario> findByNomeContainsAndEmailContains(String nome,String email);
}
