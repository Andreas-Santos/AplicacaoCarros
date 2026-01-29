package com.br.appCarros.AplicacaoCarros.validation.Deal;

import com.br.appCarros.AplicacaoCarros.request.CreateDealRequest;

public interface DealValidator {
    void validate(CreateDealRequest dealRequest);
}
