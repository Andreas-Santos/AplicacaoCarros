package com.br.appCarros.AplicacaoCarros.service;

import com.br.appCarros.AplicacaoCarros.dto.VehicleDTO;
import com.br.appCarros.AplicacaoCarros.exception.VehicleException;
import com.br.appCarros.AplicacaoCarros.mapper.VehicleMapper;
import com.br.appCarros.AplicacaoCarros.model.Vehicle;
import com.br.appCarros.AplicacaoCarros.repository.VehicleRepository;
import com.br.appCarros.AplicacaoCarros.request.VehicleRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    public VehicleDTO getVehicleById(Long id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);

        if(vehicle.isPresent())
            return vehicleMapper.toDTO(vehicle.get());

        return null;
    };

    public void createVehicle(@RequestBody @Valid VehicleRequest vehicleRequest) {
        vehicleRepository.save(vehicleMapper.toEntity(vehicleRequest));
    }

    public void deleteVehicle(Long id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);

        if(vehicle.isEmpty()) {
            throw new VehicleException("Não existe veículo com esse id!");
        }

        vehicleRepository.deleteById(id);
    }

    public void updateVehicle(Long id, @Valid VehicleRequest vehicleRequest) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);

        if(vehicleOptional.isEmpty())
            throw new VehicleException("Não existe veículo com esse id!");

        Vehicle vehicle = vehicleOptional.get();

        vehicle.updateVehicle(vehicleRequest);
    }
}
