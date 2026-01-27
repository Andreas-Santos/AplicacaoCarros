package com.br.appCarros.AplicacaoCarros.request;

import jakarta.validation.constraints.NotNull;

public record CreateDealRequest(
        @NotNull(message = "O id do veículo é obrigatório!")
        Long vehicleId,
        @NotNull(message = "O id do vendedor é obrigatório!")
        Long salesmanId,
        @NotNull(message = "O id do cliente é obrigatório!")
        Long costumerId,
        @NotNull(message = "A comissão é obrigatória!")
        Double comission
) {
}
