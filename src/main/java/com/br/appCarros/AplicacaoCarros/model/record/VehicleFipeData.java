package com.br.appCarros.AplicacaoCarros.model.record;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VehicleFipeData(
        String price,
        String brand,
        String model,
        String modelYear,
        String fuel,
        String referenceMonth
) {

}
