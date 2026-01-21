package com.br.appCarros.AplicacaoCarros.request;

import jakarta.validation.constraints.NotBlank;

public record CreateCostumerRequest(
        @NotBlank(message = "Nome é obrigatório")
        String name,
        @NotBlank(message = "CPF é obrigatório")
        String cpf,
        String email,
        String phoneNumber
) {
}
