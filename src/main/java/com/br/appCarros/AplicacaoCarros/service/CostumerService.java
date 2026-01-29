package com.br.appCarros.AplicacaoCarros.service;

import com.br.appCarros.AplicacaoCarros.dto.CostumerDTO;
import com.br.appCarros.AplicacaoCarros.exception.CostumerException;
import com.br.appCarros.AplicacaoCarros.mapper.CostumerMapper;
import com.br.appCarros.AplicacaoCarros.model.Costumer;
import com.br.appCarros.AplicacaoCarros.repository.CostumerRepository;
import com.br.appCarros.AplicacaoCarros.request.CreateCostumerRequest;
import com.br.appCarros.AplicacaoCarros.service.Utils.CpfUtils;
import com.br.appCarros.AplicacaoCarros.validation.Costumer.CostumerValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CostumerService {
    @Autowired
    CostumerRepository costumerRepository;

    @Autowired
    CostumerMapper costumerMapper;

    @Autowired
    List<CostumerValidator> validators;

    public List<CostumerDTO> getCostumers() {
        return costumerMapper.toDTO(costumerRepository.findAll());
    }

    public CostumerDTO getCostumerById(Long id) {
        Optional<Costumer> costumer = costumerRepository.findById(id);

        if(costumer.isPresent())
            return costumerMapper.toDTO(costumer.get());

        return null;
    }

    public void createCostumer(@RequestBody @Valid CreateCostumerRequest costumerRequest) {
        validators.forEach(v -> v.validate(costumerRequest));

        Costumer costumer = costumerMapper.toEntity(costumerRequest);
        costumer.cleanCpf();
        costumer.cleanPhone();

        costumerRepository.save(costumer);
    }

    public void deleteCostumer(Long id) {
        Optional<Costumer> costumer = costumerRepository.findById(id);

        if(costumer.isEmpty()) {
            throw new CostumerException("Não existe cliente com este id!");
        }

        costumerRepository.deleteById(id);
    }
}
