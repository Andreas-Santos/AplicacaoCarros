package com.br.appCarros.AplicacaoCarros.validation.Deal;

import com.br.appCarros.AplicacaoCarros.exception.DealException;
import com.br.appCarros.AplicacaoCarros.model.Vehicle;
import com.br.appCarros.AplicacaoCarros.repository.DealRepository;
import com.br.appCarros.AplicacaoCarros.repository.VehicleRepository;
import com.br.appCarros.AplicacaoCarros.request.CreateDealRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VehicleValidator implements DealValidator{
    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    DealRepository dealRepository;

    @Override
    public void validate(CreateDealRequest dealRequest) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(dealRequest.vehicleId());

        if(vehicle.isEmpty())
            throw new DealException("Não existe veículo com esse id!");

        boolean dealExists = dealRepository.existsByVehicleId(dealRequest.vehicleId());

        if(dealExists)
            throw new DealException("Já existe venda para esse veículo!");
    }
}
