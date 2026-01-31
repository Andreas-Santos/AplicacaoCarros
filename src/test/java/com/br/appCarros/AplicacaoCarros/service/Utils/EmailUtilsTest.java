package com.br.appCarros.AplicacaoCarros.service.Utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EmailUtilsTest {
    @Test
    void shouldReturnFalseWhenEmailHasNoDomain() {
        String email = "andreas";

        boolean emailIsValid = EmailUtils.isValid(email);

        Assertions.assertFalse(emailIsValid);
    }

    @Test
    void shouldReturnFalseWhenEmailHasInvalidDomainFormat() {
        String email = "andreas@.com";

        boolean emailIsValid = EmailUtils.isValid(email);

        Assertions.assertFalse(emailIsValid);
    }

    @Test
    void shouldReturnFalseWhenEmailContainsMultipleAtSymbols() {
        String email = "andreas@santos@aaa.com";

        boolean emailIsValid = EmailUtils.isValid(email);

        Assertions.assertFalse(emailIsValid);
    }

    @Test
    void shouldReturnTrueWhenEmailIsValid() {
       String email = "andreas.santos@aaa.com";

       boolean emailIsValid = EmailUtils.isValid(email);

       Assertions.assertTrue(emailIsValid);
    }
}