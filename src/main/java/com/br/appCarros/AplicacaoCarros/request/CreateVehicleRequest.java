package com.br.appCarros.AplicacaoCarros.request;

import jakarta.validation.constraints.NotBlank;

public record CreateVehicleRequest(
        @NotBlank(message = "O id da marca é obrigatório!")
        Integer brandId,
        @NotBlank(message = "O id do modelo é obrigatório!")
        Integer modelId,
        @NotBlank(message = "O id do ano é obrigatório!")
        String yearId
) {
}
