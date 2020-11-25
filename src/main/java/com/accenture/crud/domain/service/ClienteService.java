package com.accenture.crud.domain.service;

import com.accenture.crud.domain.entity.Cliente;
import com.accenture.crud.domain.repository.ClienteRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public Cliente criar(Cliente cliente){
        return clienteRepository.save(cliente);
    }


    public Cliente listarPorId (int id){

        return clienteRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Error, cliente nao encontrado", Cliente.class.getName()));
    }

    public Cliente atualizar (int id, Cliente cliente){
        return clienteRepository.findById(id)
                .map(record -> {
                    record.setNome(cliente.getNome());
                    record.setEmail(cliente.getEmail());
                    record.setTelefone(cliente.getTelefone());
                    record.setCpfCnpj(cliente.getCpfCnpj());
                    record.setLogradouro(cliente.getLogradouro());
                    record.setCidade(cliente.getCidade());
                    record.setUf(cliente.getUf());
                    record.setCep(cliente.getCep());
                    return clienteRepository.save(record);
                }).orElseThrow(() -> new ObjectNotFoundException("Error, cliente nao encontrado", Cliente.class.getName()));
    }

    public void deletar(int clientId){
        clienteRepository.deleteById(clientId);
    }

    public List<Cliente> pesquisa(String nome, String cpfCnpj, String cidade, String uf){

        var clientePesquisa = clienteRepository.pesquisa(nome,cpfCnpj,cidade,uf);
        return clientePesquisa;
    }
}
