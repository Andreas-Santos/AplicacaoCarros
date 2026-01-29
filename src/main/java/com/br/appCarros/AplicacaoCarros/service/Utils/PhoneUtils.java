package com.br.appCarros.AplicacaoCarros.service.Utils;

import org.springframework.stereotype.Component;

@Component
public class PhoneUtils {

    public static String cleanPhone(String phone) {
        if (phone == null) {
            return null;
        }
        return phone.replaceAll("\\D", "");
    }

    public static boolean isValid(String phone) {
        if(phone == null || phone.isBlank())
            return false;

        String cleanedPhone = cleanPhone(phone);

        if(cleanedPhone.length() != 10 && cleanedPhone.length() != 11)
            return false;

        return true;
    }
}
