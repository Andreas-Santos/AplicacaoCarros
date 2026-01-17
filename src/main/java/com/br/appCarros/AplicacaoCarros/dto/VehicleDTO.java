package com.br.appCarros.AplicacaoCarros.dto;

public record VehicleDTO(
        Long id,
        String brand,
        String model,
        String modelYear,
        String fuel,
        String price,
        String referenceMonth
) {

}
