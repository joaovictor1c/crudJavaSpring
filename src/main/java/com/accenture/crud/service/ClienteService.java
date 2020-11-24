package com.accenture.crud.service;

import com.accenture.crud.entity.Cliente;
import com.accenture.crud.entity.Usuario;
import com.accenture.crud.repository.ClienteRepository;
import com.accenture.crud.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public Cliente criar(Cliente cliente){
        return clienteRepository.save(cliente);
    }


    public Optional<Cliente> listarPorId (int id){

        return clienteRepository.findById(id);
    }

    public Optional<Cliente> atualizar (int id, Cliente cliente){
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
                });
    }

    public void deletar(int clientId){
        clienteRepository.deleteById(clientId);
    }

    public List<Cliente> pesquisa(String nome, String cpfCnpj, String cidade, String uf){

        var clientePesquisa = clienteRepository.pesquisa(nome,cpfCnpj,cidade,uf);
        return clientePesquisa;
    }
}
