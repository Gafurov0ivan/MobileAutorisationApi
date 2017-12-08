package com.gafur.mobile.api.mvc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author igafurov
 * @since 07.12.2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j(topic = "TEST:junit:MockMvc")
public class MvcTest {

    @Autowired
    protected MockMvc mockMvc;

    @Test
    public void testMvcEnables() {
        assertThat(mockMvc).isNotNull();
    }

}
