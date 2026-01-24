package com.br.appCarros.AplicacaoCarros.controller;

import com.br.appCarros.AplicacaoCarros.dto.VehicleDTO;
import com.br.appCarros.AplicacaoCarros.model.Vehicle;
import com.br.appCarros.AplicacaoCarros.request.CreateVehicleRequest;
import com.br.appCarros.AplicacaoCarros.service.VehicleService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public List<VehicleDTO> getVehicles() {
        return vehicleService.getVehicles();
    }

    @GetMapping("/{id}")
    public VehicleDTO getVehicleById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id);
    }

    @GetMapping("/estoque")
    public List<VehicleDTO> getVehiclesStock() {
        return vehicleService.getVehiclesStock();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> createVehicle(@RequestBody @Valid CreateVehicleRequest vehicleRequest) {
        vehicleService.createVehicle(vehicleRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body("Veículo cadastrado com sucesso!");
    }
}
