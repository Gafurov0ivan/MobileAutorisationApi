package com.gafur.mobile.api.util;

/**
 * Операции со строками при генерации кодов
 *
 * @author igafurov
 * @since 07.12.2017
 */
public class StringUtil {

    private StringUtil(){}

    public static String clearNonDigit(String str) {
        return str.replaceAll("[^\\p{IsDigit}]", "");
    }

    public static String clearNonAlphabeticNonDigit(String str) {
        return str.replaceAll("[^\\p{IsAlphabetic}^\\p{IsDigit}]", "");
    }
}
