package com.br.appCarros.AplicacaoCarros.validation.Costumer;

import com.br.appCarros.AplicacaoCarros.exception.CostumerException;
import com.br.appCarros.AplicacaoCarros.repository.CostumerRepository;
import com.br.appCarros.AplicacaoCarros.request.CreateCostumerRequest;
import com.br.appCarros.AplicacaoCarros.service.Utils.CpfUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueCpfValidator implements CostumerValidator {
    @Autowired
    CostumerRepository costumerRepository;

    @Override
    public void validate(CreateCostumerRequest costumerRequest) {
        String cpf = CpfUtils.cleanCpf(costumerRequest.cpf());

        boolean costumerByCpfExists = costumerRepository.existsByCpf(cpf);

        if(costumerByCpfExists)
            throw new CostumerException("Já existe cadastro para esse CPF");
    }
}
