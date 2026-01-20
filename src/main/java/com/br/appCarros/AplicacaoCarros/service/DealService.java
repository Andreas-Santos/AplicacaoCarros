package com.br.appCarros.AplicacaoCarros.service;

import com.br.appCarros.AplicacaoCarros.dto.DealDTO;
import com.br.appCarros.AplicacaoCarros.mapper.DealMapper;
import com.br.appCarros.AplicacaoCarros.model.Deal;
import com.br.appCarros.AplicacaoCarros.repository.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DealService {
    @Autowired
    DealRepository dealRepository;

    @Autowired
    DealMapper dealMapper;

    public List<DealDTO> getDeals() {
        return dealMapper.toDTO(dealRepository.findAll());
    }

    public DealDTO getDealById(Long id) {
        Optional<Deal> deal = dealRepository.findById(id);

        if(deal.isPresent())
            return dealMapper.toDTO(deal.get());

        return null;
    }
}
