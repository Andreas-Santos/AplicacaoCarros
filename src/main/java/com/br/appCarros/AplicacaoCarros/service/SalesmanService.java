package com.br.appCarros.AplicacaoCarros.service;

import com.br.appCarros.AplicacaoCarros.dto.SalesmanDTO;
import com.br.appCarros.AplicacaoCarros.exception.SalesmanException;
import com.br.appCarros.AplicacaoCarros.mapper.SalesmanMapper;
import com.br.appCarros.AplicacaoCarros.model.Salesman;
import com.br.appCarros.AplicacaoCarros.repository.SalesmanRepository;
import com.br.appCarros.AplicacaoCarros.request.SalesmanRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    public void createSalesman(@RequestBody @Valid SalesmanRequest salesmanRequest) {
        salesmanRepository.save(salesmanMapper.toEntity(salesmanRequest));
    }

    public void deleteSalesman(Long id) {
        Optional<Salesman> salesman = salesmanRepository.findById(id);

        if(salesman.isEmpty()) {
            throw new SalesmanException("Não existe vendedor com esse id!");
        }

        salesmanRepository.deleteById(id);
    }

    public void updateSalesman(Long id, @RequestBody @Valid SalesmanRequest salesmanRequest) {
        Optional<Salesman> salesmanOptional = salesmanRepository.findById(id);

        if(salesmanOptional.isEmpty())
            throw new SalesmanException("Não existe vendedor com esse id!");

        Salesman salesman = salesmanOptional.get();

        salesman.setName(salesmanRequest.name());
    }
}
