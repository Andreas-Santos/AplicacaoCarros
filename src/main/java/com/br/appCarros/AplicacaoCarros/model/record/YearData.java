package com.br.appCarros.AplicacaoCarros.model.record;

import com.fasterxml.jackson.annotation.JsonAlias;

public record YearData(
        @JsonAlias("code") String yearCode,
        @JsonAlias("name") String yearName
) {

}
