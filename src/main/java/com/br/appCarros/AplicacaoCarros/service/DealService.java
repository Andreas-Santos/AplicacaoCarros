package com.br.appCarros.AplicacaoCarros.service;

import com.br.appCarros.AplicacaoCarros.dto.DealDTO;
import com.br.appCarros.AplicacaoCarros.model.Deal;
import com.br.appCarros.AplicacaoCarros.repository.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DealService {
    @Autowired
    DealRepository dealRepository;

    public List<DealDTO> getDeals() {
        return dealDTOConverter(dealRepository.findAll());
    }

    public DealDTO getDealById(Long id) {
        Optional<Deal> deal = dealRepository.findById(id);

        if(deal.isPresent())
            return dealDTOConverter(deal.get());

        return null;
    }

    public List<DealDTO> dealDTOConverter(List<Deal> deals) {
        return deals.stream()
                .map(d -> new DealDTO(d))
                .collect(Collectors.toList());
    }

    public DealDTO dealDTOConverter(Deal deal) {
        return new DealDTO(deal);
    }
}
