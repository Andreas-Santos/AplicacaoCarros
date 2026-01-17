package com.br.appCarros.AplicacaoCarros.controller;

import com.br.appCarros.AplicacaoCarros.dto.VehicleDTO;
import com.br.appCarros.AplicacaoCarros.model.Vehicle;
import com.br.appCarros.AplicacaoCarros.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class VehicleController {
    @Autowired
    VehicleRepository vehicleRepository;

    @GetMapping("/veiculos")
    public List<VehicleDTO> getVehicles() {
        List<VehicleDTO> vehicles = vehicleRepository.findAll()
                .stream()
                .map(v -> new VehicleDTO(v.getId(), v.getBrand(), v.getModel(), v.getModelYear(),
                        v.getFuel(), v.getPrice(), v.getReferenceMonth()))
                .collect(Collectors.toList());

        return vehicles;
    }
}
