package com.br.appCarros.AplicacaoCarros.models.records;

import com.fasterxml.jackson.annotation.JsonAlias;

public record YearData(
        @JsonAlias("code") String yearCode,
        @JsonAlias("name") String yearName
) {

}
