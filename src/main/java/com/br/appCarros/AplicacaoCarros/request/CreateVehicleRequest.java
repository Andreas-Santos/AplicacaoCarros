package com.br.appCarros.AplicacaoCarros.request;

import jakarta.validation.constraints.NotBlank;

public record CreateVehicleRequest(
        @NotBlank(message = "O id da marca é obrigatório!")
        Integer brandId,
        @NotBlank(message = "A marca é obrigatória!")
        String brand,
        @NotBlank(message = "O id do modelo é obrigatório!")
        Integer modelId,
        @NotBlank(message = "O modelo é obrigatório!")
        String model,
        @NotBlank(message = "O id do ano é obrigatório!")
        String yearId,
        @NotBlank(message = "O ano é obrigatório!")
        String modelYear,
        @NotBlank(message = "O combustível é obrigatório!")
        String fuel,
        @NotBlank(message = "O preço é obrigatório!")
        String price,
        @NotBlank(message = "O mês de referência é obrigatório!")
        String referenceMonth
) {
}
