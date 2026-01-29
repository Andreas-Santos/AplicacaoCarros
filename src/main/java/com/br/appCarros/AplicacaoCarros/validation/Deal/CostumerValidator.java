package com.br.appCarros.AplicacaoCarros.validation.Deal;

import com.br.appCarros.AplicacaoCarros.exception.DealException;
import com.br.appCarros.AplicacaoCarros.model.Costumer;
import com.br.appCarros.AplicacaoCarros.repository.CostumerRepository;
import com.br.appCarros.AplicacaoCarros.request.DealRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CostumerValidator implements DealValidator {
    @Autowired
    CostumerRepository costumerRepository;

    @Override
    public void validate(DealRequest dealRequest) {
        Optional<Costumer> costumer = costumerRepository.findById(dealRequest.costumerId());

        if(costumer.isEmpty())
            throw new DealException("Não existe cliente com esse id!");
    }
}
