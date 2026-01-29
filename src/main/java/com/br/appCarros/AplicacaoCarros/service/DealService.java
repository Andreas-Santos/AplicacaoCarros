package com.br.appCarros.AplicacaoCarros.service;

import com.br.appCarros.AplicacaoCarros.dto.DealDTO;
import com.br.appCarros.AplicacaoCarros.exception.DealException;
import com.br.appCarros.AplicacaoCarros.mapper.DealMapper;
import com.br.appCarros.AplicacaoCarros.model.Costumer;
import com.br.appCarros.AplicacaoCarros.model.Deal;
import com.br.appCarros.AplicacaoCarros.model.Salesman;
import com.br.appCarros.AplicacaoCarros.model.Vehicle;
import com.br.appCarros.AplicacaoCarros.repository.CostumerRepository;
import com.br.appCarros.AplicacaoCarros.repository.DealRepository;
import com.br.appCarros.AplicacaoCarros.repository.SalesmanRepository;
import com.br.appCarros.AplicacaoCarros.repository.VehicleRepository;
import com.br.appCarros.AplicacaoCarros.request.DealRequest;
import com.br.appCarros.AplicacaoCarros.validation.Deal.DealValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DealService {
    @Autowired
    DealRepository dealRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    SalesmanRepository salesmanRepository;

    @Autowired
    CostumerRepository costumerRepository;

    @Autowired
    DealMapper dealMapper;

    @Autowired
    List<DealValidator> validators;

    public List<DealDTO> getDeals() {
        return dealMapper.toDTO(dealRepository.findAll());
    }

    public DealDTO getDealById(Long id) {
        Optional<Deal> deal = dealRepository.findById(id);

        if(deal.isPresent())
            return dealMapper.toDTO(deal.get());

        return null;
    }

    public void createDeal(DealRequest dealRequest) {
        validators.forEach(v -> v.validate(dealRequest));

        Vehicle vehicle = vehicleRepository.findByIdEquals(dealRequest.vehicleId());
        Salesman salesman = salesmanRepository.findByIdEquals(dealRequest.salesmanId());
        Costumer costumer = costumerRepository.findByIdEquals(dealRequest.costumerId());

        Deal deal = dealMapper.toEntity(dealRequest);

        deal.setVehicle(vehicle);
        deal.setSalesman(salesman);
        deal.setCostumer(costumer);

        dealRepository.save(deal);
    }

    public void deleteDeal(Long id) {
        Optional<Deal> deal = dealRepository.findById(id);

        if(deal.isEmpty()) {
            throw new DealException("Não existe venda com esse id!");
        }

        dealRepository.deleteById(id);
    }
}
