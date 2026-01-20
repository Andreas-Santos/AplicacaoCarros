package com.br.appCarros.AplicacaoCarros.service;

import com.br.appCarros.AplicacaoCarros.dto.CostumerDTO;
import com.br.appCarros.AplicacaoCarros.mapper.CostumerMapper;
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

    @Autowired
    CostumerMapper costumerMapper;

    public List<CostumerDTO> getCostumers() {
        return costumerMapper.toDTO(costumerRepository.findAll());
    }

    public CostumerDTO getCostumerById(Long id) {
        Optional<Costumer> costumer = costumerRepository.findById(id);

        if(costumer.isPresent())
            return costumerMapper.toDTO(costumer.get());

        return null;
    }
}
