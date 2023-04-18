package com.revanItSolutions.emailAlert.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Slf4j
public class TestRandomMessage {
    @Autowired
    private RandomMessage randomMessage;

    @Test
    public void testGetRandomMessage(){
        log.info(randomMessage.returnRandomString());
        assertThat(randomMessage.returnRandomString()).isNotEmpty();
    }
}
