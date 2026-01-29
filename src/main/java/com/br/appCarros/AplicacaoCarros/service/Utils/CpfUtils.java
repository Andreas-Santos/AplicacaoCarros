package com.br.appCarros.AplicacaoCarros.service.Utils;

import org.springframework.stereotype.Component;

@Component
public class CpfUtils {

    public static String cleanCpf(String cpf) {
        if(cpf == null)
            return null;

        return cpf.replaceAll("\\D", "");
    }
}
