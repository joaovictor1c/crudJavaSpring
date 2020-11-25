package com.accenture.crud.api.controller;

import com.accenture.crud.domain.entity.Cliente;
import com.accenture.crud.domain.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> criar (@RequestBody Cliente cliente){

        Cliente newCliente = clienteService.criar(cliente);
        return ResponseEntity.ok(newCliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> pesquisar (@RequestParam String nome, @RequestParam String cpfCnpj,@RequestParam String cidade,@RequestParam String uf){

        List<Cliente> lista = clienteService.pesquisa(nome,cpfCnpj,cidade,uf);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> listarPorId (@PathVariable int id){

        Cliente cliente = clienteService.listarPorId(id);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar (@PathVariable int id , @RequestBody Cliente cliente){

        clienteService.atualizar(id, cliente);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deletar (@PathVariable int id){

        clienteService.deletar(id);
        return ResponseEntity.status(200).build();
    }
}
