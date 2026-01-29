package com.br.appCarros.AplicacaoCarros.validation.Costumer;

import com.br.appCarros.AplicacaoCarros.request.CostumerRequest;
import org.springframework.stereotype.Component;

@Component
public interface CostumerValidator {

    void validate(CostumerRequest costumerRequest);

}
