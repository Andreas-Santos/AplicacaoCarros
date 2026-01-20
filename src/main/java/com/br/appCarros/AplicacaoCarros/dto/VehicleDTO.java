package com.br.appCarros.AplicacaoCarros.dto;

import com.br.appCarros.AplicacaoCarros.model.Vehicle;

public record VehicleDTO(
        Long id,
        String brand,
        String model,
        String modelYear,
        String fuel,
        String price,
        String referenceMonth
) {

    public VehicleDTO(Vehicle vehicle) {
        this(vehicle.getId(), vehicle.getBrand(), vehicle.getModel(), vehicle.getModelYear(), vehicle.getFuel(),
                vehicle.getPrice(), vehicle.getReferenceMonth());
    }
}
