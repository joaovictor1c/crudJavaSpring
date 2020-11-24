package com.accenture.crud.service;

import antlr.StringUtils;
import com.accenture.crud.entity.Usuario;
import com.accenture.crud.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SessaoService {

    @Autowired
    SessaoRepository sessaoRepository;

    public Boolean login(Usuario usuario){

        Usuario data = sessaoRepository.findByLogin(usuario.getLogin());

        if (!usuario.getSenha().equals(data.getSenha())) {
            return false;
        }
        if(!usuario.getStatus().equals("A")){
            return false;
        }
        return true;

    }


}
