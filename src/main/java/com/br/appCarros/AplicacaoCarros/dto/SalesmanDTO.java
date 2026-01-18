package com.br.appCarros.AplicacaoCarros.dto;

import java.time.LocalDate;

public record SalesmanDTO(
        Long id,
        String name,
        LocalDate initialDate
) {
}
