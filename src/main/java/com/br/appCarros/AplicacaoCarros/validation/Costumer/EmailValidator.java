package com.br.appCarros.AplicacaoCarros.validation.Costumer;

import com.br.appCarros.AplicacaoCarros.exception.CostumerException;
import com.br.appCarros.AplicacaoCarros.request.CreateCostumerRequest;
import com.br.appCarros.AplicacaoCarros.service.Utils.EmailUtils;

public class EmailValidator implements CostumerValidator {

    @Override
    public void validate(CreateCostumerRequest costumerRequest) {
        if(costumerRequest == null)
            throw new CostumerException("Cliente não pode ser nulo!");

        if(!EmailUtils.isValid(costumerRequest.email()))
            throw new CostumerException("E-mail inválido!");
    }
}
