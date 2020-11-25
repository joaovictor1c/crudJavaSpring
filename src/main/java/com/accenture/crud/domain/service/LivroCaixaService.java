package com.accenture.crud.domain.service;

import com.accenture.crud.domain.entity.Cliente;
import com.accenture.crud.domain.entity.LivroCaixa;
import com.accenture.crud.domain.repository.ClienteRepository;
import com.accenture.crud.domain.repository.LivroCaixaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LivroCaixaService {
    @Autowired
    LivroCaixaRepository livroCaixaRepository;

    @Autowired
    ClienteRepository clienteRepository;

    public LivroCaixa criar(int id , LivroCaixa livroCaixa){
        var criarLivro = clienteRepository.findById(id)
                .map(cliente -> {
                    livroCaixa.setCliente(cliente);
                    return livroCaixaRepository.save(livroCaixa);
                }).orElseThrow(() -> new ObjectNotFoundException("Error, cliente não encontrado", Cliente.class.getName()));

        return criarLivro;
    }


    public LivroCaixa listarPorId (int id){

        return livroCaixaRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Error, cliente não encontrado", Cliente.class.getName()));

    }
    public List<LivroCaixa> listarPorIdCliente (int id){
        return livroCaixaRepository.findByClienteId(id);
    }

    public Optional<LivroCaixa> atualizar (int id, LivroCaixa livrocaixa){
        return livroCaixaRepository.findById(id)
                .map(record -> {
                    record.setDescricao(livrocaixa.getDescricao());
                    record.setDataLancamento(livrocaixa.getDataLancamento());
                    record.setTipo(livrocaixa.getTipo());
                    record.setValor(livrocaixa.getValor());
                    return livroCaixaRepository.save(record);
                });
    }

    public void deletar(int livroId){
        livroCaixaRepository.deleteById(livroId);
    }
}
