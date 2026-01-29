package com.br.appCarros.AplicacaoCarros.validation.Costumer;

import com.br.appCarros.AplicacaoCarros.exception.CostumerException;
import com.br.appCarros.AplicacaoCarros.request.CreateCostumerRequest;
import com.br.appCarros.AplicacaoCarros.service.Utils.PhoneUtils;

public class PhoneValidator implements CostumerValidator {

    @Override
    public void validate(CreateCostumerRequest costumerRequest) {
        if(costumerRequest == null)
            throw new CostumerException("Cliente não pode ser nulo!");

        if(!PhoneUtils.isValid(costumerRequest.phoneNumber()))
            throw new CostumerException("Telefone inválido!");
    }
}
