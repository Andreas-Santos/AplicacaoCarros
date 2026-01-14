package com.br.appCarros.AplicacaoCarros.model.record;

import com.fasterxml.jackson.annotation.JsonAlias;

public record BrandData(
        @JsonAlias("code") Integer brandCode,
        @JsonAlias("name") String brandName
) {

}
