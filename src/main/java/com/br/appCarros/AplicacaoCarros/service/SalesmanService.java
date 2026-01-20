package com.br.appCarros.AplicacaoCarros.service;

import com.br.appCarros.AplicacaoCarros.dto.SalesmanDTO;
import com.br.appCarros.AplicacaoCarros.mapper.SalesmanMapper;
import com.br.appCarros.AplicacaoCarros.model.Salesman;
import com.br.appCarros.AplicacaoCarros.repository.SalesmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesmanService {
    @Autowired
    SalesmanRepository salesmanRepository;

    @Autowired
    SalesmanMapper salesmanMapper;

    public List<SalesmanDTO> getSalesman() {
        return salesmanMapper.toDTO(salesmanRepository.findAll());
    }

    public SalesmanDTO getSalesmanById(Long id) {
        Optional<Salesman> salesman = salesmanRepository.findById(id);

        if(salesman.isPresent())
            return salesmanMapper.toDTO(salesman.get());

        return null;
    }
}
