package com.br.appCarros.AplicacaoCarros.service.Utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CpfUtilsTest {
    @Test
    void shouldReturnFalseWhenCpfHasAllDigitsEqual() {
        String cpf = "11111111111";

        boolean cpfIsValid = CpfUtils.isValid(cpf);

        Assertions.assertFalse(cpfIsValid);
    }

    @Test
    void shouldReturnFalseWhenCpfHasInvalidCheckDigits() {
        String cpf = "12345678910";

        boolean cpfIsValid = CpfUtils.isValid(cpf);

        Assertions.assertFalse(cpfIsValid);
    }

    @Test
    void shouldReturnFalseWhenFormattedCpfHasInvalidCheckDigits() {
        String cpf = "123.456.789-10";

        boolean cpfIsValid = CpfUtils.isValid(cpf);

        Assertions.assertFalse(cpfIsValid);
    }

    @Test
    void shouldReturnFalseWhenCpfDoesNotContainValidNumbers() {
        String cpf = "...///***--";

        boolean cpfIsValid = CpfUtils.isValid(cpf);

        Assertions.assertFalse(cpfIsValid);
    }

    @Test
    void shouldReturnFalseWhenCpfHasInvalidNumericSequence() {
        String cpf = "122.233.455-09";

        boolean cpfIsValid = CpfUtils.isValid(cpf);

        Assertions.assertFalse(cpfIsValid);
    }

    @Test
    void shouldReturnTrueWhenFormattedCpfIsValid() {
        String cpf = "896.345.260-39";

        boolean cpfIsValid = CpfUtils.isValid(cpf);

        Assertions.assertTrue(cpfIsValid);
    }

    @Test
    void shouldReturnTrueWhenUnformattedCpfIsValid() {
        String cpf = "24010376082";

        boolean cpfIsValid = CpfUtils.isValid(cpf);

        Assertions.assertTrue(cpfIsValid);
    }

    @Test
    void shouldReturnTrueWhenCpfHasExtraCharactersButValidNumbers() {
        String cpf = "277.970.570-10///**()";

        boolean cpfIsValid = CpfUtils.isValid(cpf);

        Assertions.assertTrue(cpfIsValid);
    }

    @Test
    void shouldReturnTrueWhenFormattedCpfHasTrailingSpaces() {
        String cpf = "792.580.360-69 ";

        boolean cpfIsValid = CpfUtils.isValid(cpf);

        Assertions.assertTrue(cpfIsValid);
    }

    @Test
    void shouldReturnTrueWhenUnformattedCpfHasExtraCharacters() {
        String cpf = "34518972023..-";

        boolean cpfIsValid = CpfUtils.isValid(cpf);

        Assertions.assertTrue(cpfIsValid);
    }
}