package com.br.appCarros.AplicacaoCarros.validation.Costumer;

import com.br.appCarros.AplicacaoCarros.request.CreateCostumerRequest;
import org.springframework.stereotype.Component;

@Component
public interface CostumerValidator {

    void validate(CreateCostumerRequest costumerRequest);

}
