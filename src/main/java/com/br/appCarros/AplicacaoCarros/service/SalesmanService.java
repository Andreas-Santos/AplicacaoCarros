package com.br.appCarros.AplicacaoCarros.service;

import com.br.appCarros.AplicacaoCarros.dto.SalesmanDTO;
import com.br.appCarros.AplicacaoCarros.model.Salesman;
import com.br.appCarros.AplicacaoCarros.repository.SalesmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SalesmanService {
    @Autowired
    SalesmanRepository salesmanRepository;

    public List<SalesmanDTO> getSalesman() {
        return salesmanDTOConverter(salesmanRepository.findAll());
    }

    public SalesmanDTO getSalesmanById(Long id) {
        Optional<Salesman> salesman = salesmanRepository.findById(id);

        if(salesman.isPresent())
            return salesmanDTOConverter(salesman.get());

        return null;
    }

    public List<SalesmanDTO> salesmanDTOConverter(List<Salesman> salesman) {
        return salesman.stream()
                .map(s -> new SalesmanDTO(s))
                .collect(Collectors.toList());
    }

    public SalesmanDTO salesmanDTOConverter(Salesman salesman) {
        return new SalesmanDTO(salesman);
    }
}
