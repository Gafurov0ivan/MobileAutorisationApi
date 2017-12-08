package com.gafur.mobile.api.help;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * @author igafurov
 * @since 07.12.2017
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
@Slf4j(topic = "TEST:TestNG")
public class AppSpringBootTestNG extends AbstractTestNGSpringContextTests {
}
