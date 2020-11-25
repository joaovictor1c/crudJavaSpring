package com.accenture.crud.domain.service;

import com.accenture.crud.domain.entity.Usuario;
import com.accenture.crud.domain.repository.SessaoRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
