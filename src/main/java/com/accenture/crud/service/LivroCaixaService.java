package com.accenture.crud.service;

import com.accenture.crud.entity.LivroCaixa;
import com.accenture.crud.repository.ClienteRepository;
import com.accenture.crud.repository.LivroCaixaRepository;
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

    public Optional<LivroCaixa> criar(int id , LivroCaixa livroCaixa){
        var criarLivro = clienteRepository.findById(id)
                .map(cliente -> {
                    livroCaixa.setCliente(cliente);
                    return livroCaixaRepository.save(livroCaixa);
                });
        return criarLivro;
    }


    public Optional<LivroCaixa> listarPorId (int id){

        return livroCaixaRepository.findById(id);
    }
    public List<LivroCaixa> listarPorIdCliente (int id){
        return livroCaixaRepository.findByCliente(id);
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
