package com.br.appCarros.AplicacaoCarros.dto;


import com.br.appCarros.AplicacaoCarros.model.Costumer;

public record CostumerDTO(
        Long id,
        String name,
        String cpf,
        String email,
        String phoneNumber
) {

    public CostumerDTO(Costumer costumer) {
        this(costumer.getId(), costumer.getName(), costumer.getCpf(), costumer.getEmail(), costumer.getPhoneNumber());
    }
}
