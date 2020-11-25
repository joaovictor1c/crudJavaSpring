package com.accenture.crud.api.controller;

import com.accenture.crud.domain.entity.Usuario;
import com.accenture.crud.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> criar (@RequestBody Usuario usuario){

        Usuario newUser = usuarioService.criar(usuario);
        return ResponseEntity.ok(newUser);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> pesquisar (@RequestParam String nome, @RequestParam String email){

        List<Usuario> lista = usuarioService.pesquisa(nome,email);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> listarPorId (@PathVariable int id){

        Usuario usuario = usuarioService.listarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar (@PathVariable int id , @RequestBody Usuario usuario){

        usuarioService.atualizar(id, usuario);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deletar (@PathVariable int id){

        usuarioService.deletar(id);
        return ResponseEntity.status(200).build();
    }

}
