package com.br.appCarros.AplicacaoCarros.request;

import jakarta.validation.constraints.NotBlank;

public record CreateSalesmanRequest(
        @NotBlank
        String name
) {
}
