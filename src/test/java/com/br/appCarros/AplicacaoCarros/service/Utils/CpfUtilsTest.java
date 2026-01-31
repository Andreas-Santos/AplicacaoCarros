package com.br.appCarros.AplicacaoCarros.service.Utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CpfUtilsTest {
    @Test
    void invalidCpfCenario01() {
        String cpf = "11111111111";

        boolean cpfIsValid = CpfUtils.isValid(cpf);

        Assertions.assertFalse(cpfIsValid);
    }

    @Test
    void invalidCpfCenario02() {
        String cpf = "12345678910";

        boolean cpfIsValid = CpfUtils.isValid(cpf);

        Assertions.assertFalse(cpfIsValid);
    }

    @Test
    void invalidCpfCenario03() {
        String cpf = "123.456.789-10";

        boolean cpfIsValid = CpfUtils.isValid(cpf);

        Assertions.assertFalse(cpfIsValid);
    }

    @Test
    void invalidCpfCenario04() {
        String cpf = "...///***--";

        boolean cpfIsValid = CpfUtils.isValid(cpf);

        Assertions.assertFalse(cpfIsValid);
    }

    @Test
    void invalidCpfCenario05() {
        String cpf = "122.233.455-09";

        boolean cpfIsValid = CpfUtils.isValid(cpf);

        Assertions.assertFalse(cpfIsValid);
    }

    @Test
    void validCpfCenario01() {
        String cpf = "896.345.260-39";

        boolean cpfIsValid = CpfUtils.isValid(cpf);

        Assertions.assertTrue(cpfIsValid);
    }

    @Test
    void validCpfCenario02() {
        String cpf = "24010376082";

        boolean cpfIsValid = CpfUtils.isValid(cpf);

        Assertions.assertTrue(cpfIsValid);
    }

    @Test
    void validCpfCenario03() {
        String cpf = "277.970.570-10///**()";

        boolean cpfIsValid = CpfUtils.isValid(cpf);

        Assertions.assertTrue(cpfIsValid);
    }

    @Test
    void validCpfCenario04() {
        String cpf = "792.580.360-69 ";

        boolean cpfIsValid = CpfUtils.isValid(cpf);

        Assertions.assertTrue(cpfIsValid);
    }

    @Test
    void validCpfCenario05() {
        String cpf = "34518972023..-";

        boolean cpfIsValid = CpfUtils.isValid(cpf);

        Assertions.assertTrue(cpfIsValid);
    }
}