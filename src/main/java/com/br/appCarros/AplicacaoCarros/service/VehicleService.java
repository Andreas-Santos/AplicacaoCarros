package com.br.appCarros.AplicacaoCarros.service;

import com.br.appCarros.AplicacaoCarros.dto.VehicleDTO;
import com.br.appCarros.AplicacaoCarros.model.Vehicle;
import com.br.appCarros.AplicacaoCarros.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;

    public List<VehicleDTO> getVehicles() {
        return VehicleDTOConverter(vehicleRepository.findAll());
    }

    public List<VehicleDTO> getVehiclesStock() {
        return VehicleDTOConverter(vehicleRepository.findByDealIsNull());
    }

    public List<VehicleDTO> VehicleDTOConverter(List<Vehicle> vehicles) {
        return vehicles.stream()
                .map(v -> new VehicleDTO(v))
                .collect(Collectors.toList());
    }

    public VehicleDTO VehicleDTOConverter(Vehicle vehicle) {
        return new VehicleDTO(vehicle);
    }

    public VehicleDTO getVehicleById(Long id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);

        if(vehicle.isPresent())
            return VehicleDTOConverter(vehicle.get());

        return null;
    };
}
