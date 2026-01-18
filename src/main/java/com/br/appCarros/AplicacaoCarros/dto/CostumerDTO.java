package com.br.appCarros.AplicacaoCarros.dto;

import com.br.appCarros.AplicacaoCarros.model.Deal;

import java.util.List;

public record CostumerDTO(
        Long id,
        String name,
        String cpf,
        String email,
        String phoneNumber
) {
}
