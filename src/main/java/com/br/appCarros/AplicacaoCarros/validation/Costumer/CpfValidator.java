package com.br.appCarros.AplicacaoCarros.validation.Costumer;

import com.br.appCarros.AplicacaoCarros.exception.CostumerException;
import com.br.appCarros.AplicacaoCarros.request.CostumerRequest;
import com.br.appCarros.AplicacaoCarros.service.Utils.CpfUtils;
import org.springframework.stereotype.Component;

@Component
public class CpfValidator implements CostumerValidator{

    @Override
    public void validate(CostumerRequest costumerRequest) {
        if(costumerRequest == null)
            throw new CostumerException("Cliente não pode ser nulo!");

        if(!CpfUtils.isValid(costumerRequest.cpf()))
            throw new CostumerException("CPF inválido!");

    }
}
