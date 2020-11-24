package com.accenture.crud.service;

import com.accenture.crud.entity.Usuario;
import com.accenture.crud.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Optional;


@Component
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario criar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> pesquisa(String nome, String email){

        if(!nome.isEmpty() && !email.isEmpty()){
            return usuarioRepository.findByNomeContainsAndEmailContains(nome,email);
        }
        if(!nome.isEmpty()){
            return usuarioRepository.findByNomeContains(nome);
        }
        if(!email.isEmpty()){
            return usuarioRepository.findByEmailContains(email);
        }
        return usuarioRepository.findAll();

    }

    public Optional<Usuario> listarPorId (int id){

        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> atualizar (int id, Usuario usuario){
        return usuarioRepository.findById(id)
            .map(record -> {
                record.setNome(usuario.getNome());
                record.setEmail(usuario.getEmail());
                record.setTelefone(usuario.getTelefone());
                record.setSenha(usuario.getSenha());
                record.setStatus(usuario.getStatus());
                record.setPerfil(usuario.getPerfil());
                return usuarioRepository.save(record);
            });
    }

    public void deletar(int userId){
        usuarioRepository.deleteById(userId);
    }

}
