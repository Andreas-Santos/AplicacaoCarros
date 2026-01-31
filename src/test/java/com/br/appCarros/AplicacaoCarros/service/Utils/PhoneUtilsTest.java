package com.br.appCarros.AplicacaoCarros.service.Utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PhoneUtilsTest {
    @Test
    void shouldReturnFalseWhenPhoneHasMoreThanElevenDigits() {
        String phone = "1234567891011";

        boolean phoneIsValid = PhoneUtils.isValid(phone);

        Assertions.assertFalse(phoneIsValid);
    }

    @Test
    void shouldReturnFalseWhenPhoneIsEmpty() {
        String phone = "";

        boolean phoneIsValid = PhoneUtils.isValid(phone);

        Assertions.assertFalse(phoneIsValid);
    }

    @Test
    void shouldReturnTrueWhenPhoneHasOnlyNumbersAndIsValid() {
        String phone = "15998462533";

        boolean phoneIsValid = PhoneUtils.isValid(phone);

        Assertions.assertTrue(phoneIsValid);
    }

    @Test
    void shouldReturnTrueWhenPhoneHasFormattingCharacters() {
        String phone = "(15) 99846-2533";

        boolean phoneIsValid = PhoneUtils.isValid(phone);

        Assertions.assertTrue(phoneIsValid);
    }

    @Test
    void shouldReturnTrueWhenPhoneContainsSpecialCharactersThatCanBeIgnored() {
        String phone = "15998462533  *// ";

        boolean phoneIsValid = PhoneUtils.isValid(phone);

        Assertions.assertTrue(phoneIsValid);
    }
}