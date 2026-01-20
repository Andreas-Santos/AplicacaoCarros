package com.br.appCarros.AplicacaoCarros.service;

import com.br.appCarros.AplicacaoCarros.dto.VehicleDTO;
import com.br.appCarros.AplicacaoCarros.mapper.VehicleMapper;
import com.br.appCarros.AplicacaoCarros.model.Vehicle;
import com.br.appCarros.AplicacaoCarros.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    VehicleMapper vehicleMapper;

    public List<VehicleDTO> getVehicles() {
        return vehicleMapper.toDTO(vehicleRepository.findAll());
    }

    public List<VehicleDTO> getVehiclesStock() {
        return vehicleMapper.toDTO(vehicleRepository.findByDealIsNull());
    }

    public VehicleDTO getVehicleById(Long id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);

        if(vehicle.isPresent())
            return vehicleMapper.toDTO(vehicle.get());

        return null;
    };
}
