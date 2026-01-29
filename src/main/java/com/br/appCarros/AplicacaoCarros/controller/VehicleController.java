package com.br.appCarros.AplicacaoCarros.controller;

import com.br.appCarros.AplicacaoCarros.dto.VehicleDTO;
import com.br.appCarros.AplicacaoCarros.request.VehicleRequest;
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

    @PostMapping
    @Transactional
    public ResponseEntity<String> createVehicle(@RequestBody @Valid VehicleRequest vehicleRequest) {
        vehicleService.createVehicle(vehicleRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body("Veículo cadastrado com sucesso!");
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);

        return ResponseEntity.status(HttpStatus.OK).body("Veículo deletado com sucesso!");
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<String> updateVehicle(
            @PathVariable Long id,
            @RequestBody @Valid VehicleRequest vehicleRequest) {
        vehicleService.updateVehicle(id, vehicleRequest);

        return ResponseEntity.status(HttpStatus.OK).body("Veículo alterado com sucesso!");
    }
}
