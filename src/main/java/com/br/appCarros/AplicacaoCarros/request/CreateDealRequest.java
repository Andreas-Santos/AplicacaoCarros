package com.br.appCarros.AplicacaoCarros.request;

import jakarta.validation.constraints.NotBlank;

public record CreateDealRequest(
        Long vehicleId,
        Long salesmanId,
        Long costumerId,
        Double comission
) {
}
