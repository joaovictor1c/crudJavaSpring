package com.accenture.crud.controller;

import com.accenture.crud.entity.Usuario;
import com.accenture.crud.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

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
    public ResponseEntity<Optional<Usuario>> listarPorId (@PathVariable int id){

        Optional<Usuario> usuario = usuarioService.listarPorId(id);
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
