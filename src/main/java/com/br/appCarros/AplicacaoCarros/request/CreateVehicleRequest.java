package com.br.appCarros.AplicacaoCarros.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateVehicleRequest(
        @NotNull(message = "O id da marca é obrigatório!")
        Long brandId,
        @NotBlank(message = "A marca é obrigatória!")
        String brand,
        @NotNull(message = "O id do modelo é obrigatório!")
        Long modelId,
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
