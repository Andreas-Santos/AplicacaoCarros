package com.br.appCarros.AplicacaoCarros.validation.Deal;

import com.br.appCarros.AplicacaoCarros.exception.DealException;
import com.br.appCarros.AplicacaoCarros.model.Salesman;
import com.br.appCarros.AplicacaoCarros.repository.SalesmanRepository;
import com.br.appCarros.AplicacaoCarros.request.CreateDealRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SalesmanValidator implements DealValidator {
    @Autowired
    SalesmanRepository salesmanRepository;

    @Override
    public void validate(CreateDealRequest dealRequest) {
        Optional<Salesman> salesman = salesmanRepository.findById(dealRequest.salesmanId());

        if(salesman.isEmpty())
            throw new DealException("Não existe vendedor com esse id!");
    }
}
