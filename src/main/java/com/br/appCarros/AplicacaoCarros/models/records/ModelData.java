package com.br.appCarros.AplicacaoCarros.models.records;

import com.fasterxml.jackson.annotation.JsonAlias;

public record ModelData(
        @JsonAlias("code") Integer modelCode,
        @JsonAlias("name") String modelName
) {

}
