package com.br.appCarros.AplicacaoCarros.request;

import jakarta.validation.constraints.NotBlank;

public record SalesmanRequest(
        @NotBlank(message = "Nome é obrigatório")
        String name
) {
}
