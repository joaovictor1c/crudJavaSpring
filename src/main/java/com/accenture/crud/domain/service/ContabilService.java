package com.accenture.crud.domain.service;

import com.accenture.crud.domain.entity.Cliente;
import com.accenture.crud.domain.entity.DTO.ContabilDTO;
import com.accenture.crud.domain.entity.DTO.LivroCaixaDTO;
import com.accenture.crud.domain.entity.LivroCaixa;
import com.accenture.crud.domain.repository.ClienteRepository;
import com.accenture.crud.domain.repository.LivroCaixaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ContabilService {
    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    LivroCaixaRepository livroCaixaRepository;

    public ContabilDTO contabilById(int id){
        var filtro = new ContabilDTO();

        Cliente clientes = clienteRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Error, cliente nao encontrado", Cliente.class.getName()));

        var livrocaixa = livroCaixaRepository.findByClienteId(clientes.getId());

        filtro.setId(clientes.getId());
        filtro.setNome(clientes.getNome());
        filtro.setCpfCpnj(clientes.getCpfCnpj());
        filtro.setTelefone(clientes.getTelefone());

        List<LivroCaixaDTO> livroCaixaDTOS = mappingLivroCaixaDTO(livrocaixa);

        for(LivroCaixaDTO livroCaixa : livroCaixaDTOS ){
            filtro.getContabil().add(livroCaixa);
        }

        return filtro;
    }

    public ContabilDTO findByIdAndDate(int id, String startDate, String endDate) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date start = dateFormat.parse(startDate);
        Date end = dateFormat.parse(endDate);


        ContabilDTO filtro = new ContabilDTO();

        var cliente = clienteRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Error, cliente nao encontrado", Cliente.class.getName()));

        List<LivroCaixa> livrocaixa = livroCaixaRepository.findByClienteIdAndDataLancamentoBetween(id, start, end);



        filtro.setId(cliente.getId());
        filtro.setNome(cliente.getNome());
        filtro.setCpfCpnj(cliente.getCpfCnpj());
        filtro.setTelefone(cliente.getTelefone());
        List<LivroCaixaDTO> livroCaixaDTOS = mappingLivroCaixaDTO(livrocaixa);

        for(LivroCaixaDTO livroCaixa : livroCaixaDTOS ){
            filtro.getContabil().add(livroCaixa);
        }

        return filtro;
    }

    public List<LivroCaixaDTO> mappingLivroCaixaDTO(List<LivroCaixa> dto){
        List<LivroCaixaDTO> livroCaixaDTOList = new ArrayList<>();
        Double somatotal = 0.0;

        for(LivroCaixa livroCaixa : dto){
            if(livroCaixa.getTipo().equals("C")){
                somatotal = somatotal + livroCaixa.getValor();

                LivroCaixaDTO livroCaixaDTO = new LivroCaixaDTO();

                livroCaixaDTO.setDataLancamento(livroCaixa.getDataLancamento());
                livroCaixaDTO.setDescricao(livroCaixa.getDescricao());
                livroCaixaDTO.setTipo(livroCaixa.getTipo());
                livroCaixaDTO.setValor(livroCaixa.getValor());
                livroCaixaDTO.setSaldo(somatotal);

                livroCaixaDTOList.add(livroCaixaDTO);

            }else{
                somatotal = somatotal - livroCaixa.getValor();

                LivroCaixaDTO livroCaixaDTO = new LivroCaixaDTO();

                livroCaixaDTO.setDataLancamento(livroCaixa.getDataLancamento());
                livroCaixaDTO.setDescricao(livroCaixa.getDescricao());
                livroCaixaDTO.setTipo(livroCaixa.getTipo());
                livroCaixaDTO.setValor(livroCaixa.getValor());
                livroCaixaDTO.setSaldo(somatotal);

                livroCaixaDTOList.add(livroCaixaDTO);
            }
        }

        return livroCaixaDTOList;
    }
}
