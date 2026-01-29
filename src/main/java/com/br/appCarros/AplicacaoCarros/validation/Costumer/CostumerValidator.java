package com.br.appCarros.AplicacaoCarros.validation.Costumer;

import com.br.appCarros.AplicacaoCarros.request.CreateCostumerRequest;

public interface CostumerValidator {

    boolean validate(CreateCostumerRequest costumerRequest);

}
