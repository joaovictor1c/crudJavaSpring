package com.accenture.crud.api.controller;
import javax.validation.Valid;

import com.accenture.crud.domain.entity.LivroCaixa;
import com.accenture.crud.domain.service.LivroCaixaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/livrocaixa")
public class LivroCaixaController {

    @Autowired
    private LivroCaixaService livroCaixaService;


    @PostMapping("/{id}/cliente")
    public ResponseEntity<LivroCaixa> criar (@PathVariable int id , @Valid @RequestBody LivroCaixa livroCaixa){

        var livro  = livroCaixaService.criar(id, livroCaixa);
        return ResponseEntity.ok(livro);
    }


    @GetMapping("/{id}")
    public ResponseEntity<LivroCaixa> listarPorId (@PathVariable int id){

        LivroCaixa livrocaixa = livroCaixaService.listarPorId(id);
        return ResponseEntity.ok(livrocaixa);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<LivroCaixa>> listarPorClienteId (@PathVariable int id){

        var livrocaixa = livroCaixaService.listarPorIdCliente(id);
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
