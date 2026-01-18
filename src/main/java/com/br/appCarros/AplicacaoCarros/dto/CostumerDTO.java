package com.br.appCarros.AplicacaoCarros.dto;


public record CostumerDTO(
        Long id,
        String name,
        String cpf,
        String email,
        String phoneNumber
) {
}
