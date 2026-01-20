package com.br.appCarros.AplicacaoCarros.dto;

import com.br.appCarros.AplicacaoCarros.model.Salesman;

import java.time.LocalDate;

public record SalesmanDTO(
        Long id,
        String name,
        LocalDate initialDate
) {
}
