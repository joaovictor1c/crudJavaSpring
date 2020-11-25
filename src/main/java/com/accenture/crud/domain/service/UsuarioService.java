package com.accenture.crud.domain.service;

import com.accenture.crud.domain.entity.Usuario;
import com.accenture.crud.domain.repository.UsuarioRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


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

    public Usuario listarPorId (int id){

        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Error, usuario não encontrado", Usuario.class.getName()));
    }

    public Usuario atualizar (int id, Usuario usuario){
        return usuarioRepository.findById(id)
            .map(record -> {
                record.setNome(usuario.getNome());
                record.setEmail(usuario.getEmail());
                record.setTelefone(usuario.getTelefone());
                record.setSenha(usuario.getSenha());
                record.setStatus(usuario.getStatus());
                record.setPerfil(usuario.getPerfil());
                return usuarioRepository.save(record);
            }).orElseThrow(() -> new ObjectNotFoundException("Error, usuario não encontrado", Usuario.class.getName()));
    }

    public void deletar(int userId){
        usuarioRepository.deleteById(userId);
    }

}
