package com.gafur.mobile.api.mvc;

import com.gafur.mobile.api.rest.model.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author igafurov
 * @since 07.12.2017
 */
public class RegistrationRestTests extends MvcTest {

    @Autowired
    com.gafur.mobile.api.util.JsonUtil JsonUtil;

    @Test
    public void testNotValidForConfirmation() throws Exception {
        AccountConfirmDto account = new AccountConfirmDto();
        account.setPhone("17053264519");
        account.setCode("test");

        this.mockMvc.perform(
                post("/v1/account/confirm")
                        .content(JsonUtil.asJsonString(account))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotAcceptable())
                .andExpect(jsonPath("$.error").value("NotValidFormException"));
    }

    @Test
    public void testAuthAndConfirm() throws Exception {
        AccountRegistrationDto account = new AccountRegistrationDto();
        account.setPhone("15053264519");
        account.setPassword("Qwert123");

        SmsTemplateDto smsTemplate = new SmsTemplateDto();
        smsTemplate.setApplicationName("android app");
        smsTemplate.setVerificationText("Your #APP_NAME# verification code is #AUTH_CODE#");
        account.setTemplate(smsTemplate);

        UserProfileDto userProfile = new UserProfileDto();
        userProfile.setLastName("John");
        userProfile.setFirstName("Doe");
        userProfile.setPatronymic("Ivanovich");
        userProfile.setEmailAddress("address@gmail.com");
        userProfile.setAvatarLink("https://www.google.ru/intl/myavatar");
        account.setUserProfile(userProfile);

        this.mockMvc.perform(
                post("/v1/account/registration")
                        .content(JsonUtil.asJsonString(account))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

        AccountConfirmDto accountToConfirm = new AccountConfirmDto();
        accountToConfirm.setPhone("15053264519");
        accountToConfirm.setCode("CW7T863H");

        this.mockMvc.perform(
                post("/v1/account/confirm")
                        .content(JsonUtil.asJsonString(accountToConfirm))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

        AccountLoginDto login = new AccountLoginDto();
        login.setPhone("15053264519");
        login.setPassword("Qwert123");

        this.mockMvc.perform(
                post("/v1/account/login")
                        .content(JsonUtil.asJsonString(login))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
