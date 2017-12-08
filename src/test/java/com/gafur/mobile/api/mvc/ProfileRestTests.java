package com.gafur.mobile.api.mvc;

import com.gafur.mobile.api.rest.model.UserProfileDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author igafurov
 * @since 07.12.2017
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class ProfileRestTests extends MvcTest {

    @Autowired
    com.gafur.mobile.api.util.JsonUtil JsonUtil;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
    }

    @Test
    public void testCreateProfile() throws Exception {
        UserProfileDto userProfile = new UserProfileDto();
        userProfile.setLastName("John");
        userProfile.setFirstName("Doe");
        userProfile.setPatronymic("Ivanovich");
        userProfile.setEmailAddress("address@gmail.com");
        userProfile.setAvatarLink("https://www.google.ru/intl/myavatar");

        mvc.perform(
                post("/v1/profile/create")
                        .content(JsonUtil.asJsonString(userProfile))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .with(user("user")))
                .andDo(print())
                .andExpect(status().isOk());

        mvc.perform(get("/v1/profile/get?phone=15053264519")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .with(user("user")))
                .andDo(print())
                .andExpect(status().isOk());

    }
}

