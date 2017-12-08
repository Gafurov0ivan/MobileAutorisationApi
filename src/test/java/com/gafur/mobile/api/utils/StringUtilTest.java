package com.gafur.mobile.api.utils;

import com.gafur.mobile.api.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author igafurov
 * @since 07.12.2017
 */
@Slf4j
public class StringUtilTest {

    String strToClear = "D\nM\t.*+)$#BW-2T-XC5456456-NLДывыdsfvddf/dfb?dfbвäöKKмывъїє".toUpperCase();

    @Test
    public void testConfirmationCode() {
        String code = StringUtil.clearNonAlphabeticNonDigit(strToClear);
        assertThat(code).isEqualTo("DMBW2TXC5456456NLДЫВЫDSFVDDFDFBDFBВÄÖKKМЫВЪЇЄ");
    }

    @Test
    public void testConfirmationCodeNumeric() {
        String code = StringUtil.clearNonDigit(strToClear);
        assertThat(code).isEqualTo("25456456");
    }
}
