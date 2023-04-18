package com.revanItSolutions.emailAlert.sendEmail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class TestEmailDetails {
    @Test
    public void testEmailDetails(){
        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setRecipient("test@test.com");
        emailDetails.setSubject("test");
        emailDetails.setMsgBody("Test Body");
        emailDetails.setAttachment("Attachments");
        assertThat(emailDetails.getRecipient()).isEqualTo("test@test.com");
        assertThat(emailDetails.getSubject()).isEqualTo("test");
        assertThat(emailDetails.getMsgBody()).isEqualTo("Test Body");
        assertThat(emailDetails.getAttachment()).isEqualTo("Attachments");

        EmailDetails allArgsEmailDetails = new EmailDetails("test@test.com","Test Body","test","Attachments");
        assertThat(allArgsEmailDetails.getRecipient()).isEqualTo("test@test.com");
        assertThat(allArgsEmailDetails.getSubject()).isEqualTo("test");
        assertThat(allArgsEmailDetails.getMsgBody()).isEqualTo("Test Body");
        assertThat(allArgsEmailDetails.getAttachment()).isEqualTo("Attachments");
    }
}
