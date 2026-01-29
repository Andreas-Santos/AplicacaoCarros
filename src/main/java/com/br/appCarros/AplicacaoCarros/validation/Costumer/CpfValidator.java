package com.br.appCarros.AplicacaoCarros.validation.Costumer;

import com.br.appCarros.AplicacaoCarros.request.CreateCostumerRequest;
import com.br.appCarros.AplicacaoCarros.service.Utils.CpfUtils;

public class CpfValidator implements CostumerValidator{

    @Override
    public boolean validate(CreateCostumerRequest costumerRequest) {
        if (costumerRequest.cpf() == null || costumerRequest.cpf().isBlank())
            return false;

        String cleanedCpf = CpfUtils.cleanCpf(costumerRequest.cpf());

        if(cleanedCpf.length() != 11)
            return false;

        if(cleanedCpf.matches("(\\d)\\1{10}"))
            return false;

        int sum = 0;
        for(int i = 0; i < 9; i++) {
            sum += Character.getNumericValue(cleanedCpf.charAt(i) * (10 - i));
        }

        int digit1 = (sum * 10) % 11;
        digit1 = digit1 == 10 ? 0 : digit1;

        sum = 0;
        for(int i = 0; i < 10; i++) {
            sum += Character.getNumericValue(cleanedCpf.charAt(i) * (11 - i));
        }

        int digit2 = (sum * 10) % 11;
        digit2 = digit2 == 10 ? 0 : digit2;

        return (digit1 == Character.getNumericValue(cleanedCpf.charAt(9))) &&
                (digit2 == Character.getNumericValue(cleanedCpf.charAt(10)));
    }
}
