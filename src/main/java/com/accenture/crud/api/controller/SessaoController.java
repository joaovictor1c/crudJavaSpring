package com.accenture.crud.api.controller;

import com.accenture.crud.domain.entity.Usuario;
import com.accenture.crud.domain.service.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sessao")
public class SessaoController {

    @Autowired
    private SessaoService sessaoService;

    @PostMapping
    public ResponseEntity<Boolean> login (@RequestBody Usuario usuario){
        var login = sessaoService.login(usuario);
        return ResponseEntity.ok(login);
    }
}
