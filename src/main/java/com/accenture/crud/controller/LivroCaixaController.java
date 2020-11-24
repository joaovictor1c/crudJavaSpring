package com.accenture.crud.controller;
import javax.validation.Valid;

import com.accenture.crud.entity.LivroCaixa;
import com.accenture.crud.repository.ClienteRepository;
import com.accenture.crud.service.LivroCaixaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/livrocaixa")
public class LivroCaixaController {

    @Autowired
    LivroCaixaService livroCaixaService;


    @PostMapping("/{id}/cliente")
    public ResponseEntity<Optional<LivroCaixa>> criar (@PathVariable int id , @Valid @RequestBody LivroCaixa livroCaixa){

        var livro  = livroCaixaService.criar(id, livroCaixa);
        return ResponseEntity.ok(livro);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<LivroCaixa>> listarPorId (@PathVariable int id){

        Optional<LivroCaixa> livrocaixa = livroCaixaService.listarPorId(id);
        return ResponseEntity.ok(livrocaixa);
    }

    @GetMapping("/{clienteId}/cliente")
    public ResponseEntity<List<LivroCaixa>> listarPorClienteId (@PathVariable int clienteId){

        var livrocaixa = livroCaixaService.listarPorIdCliente(clienteId);
        return ResponseEntity.ok(livrocaixa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroCaixa> atualizar (@PathVariable int id , @RequestBody LivroCaixa livroCaixa){

        livroCaixaService.atualizar(id, livroCaixa);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LivroCaixa> deletar (@PathVariable int id){

        livroCaixaService.deletar(id);
        return ResponseEntity.status(200).build();
    }
}
