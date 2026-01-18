package com.br.appCarros.AplicacaoCarros.service;

import com.br.appCarros.AplicacaoCarros.dto.CostumerDTO;
import com.br.appCarros.AplicacaoCarros.model.Costumer;
import com.br.appCarros.AplicacaoCarros.repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CostumerService {
    @Autowired
    CostumerRepository costumerRepository;

    public List<CostumerDTO> getCostumers() {
        return CostumerDTOConverter(costumerRepository.findAll());
    }

    public CostumerDTO getCostumerById(Long id) {
        Optional<Costumer> costumer = costumerRepository.findById(id);

        if(costumer.isPresent())
            return CostumerDTOConverter(costumer.get());

        return null;
    }

    public List<CostumerDTO> CostumerDTOConverter(List<Costumer> costumers) {
        return costumers.stream()
                .map(c -> new CostumerDTO(c.getId(), c.getName(), c.getCpf(), c.getEmail(), c.getPhoneNumber()))
                .collect(Collectors.toList());
    }

    public CostumerDTO CostumerDTOConverter(Costumer costumer) {
        return new CostumerDTO(costumer.getId(), costumer.getName(), costumer.getCpf(), costumer.getEmail(),
                costumer.getPhoneNumber());
    }
}
