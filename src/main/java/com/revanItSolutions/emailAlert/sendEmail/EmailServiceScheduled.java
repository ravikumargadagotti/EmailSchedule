package com.revanItSolutions.emailAlert.sendEmail;

import com.revanItSolutions.emailAlert.util.RandomMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailServiceScheduled{
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private RandomMessage randomMessage;

    @Value("${spring.mail.username}") private String sender;
    @Scheduled(cron = "0 30 20 * * MON-FRI")
    public String sendSimpleMail() {

        // Try block to check for exceptions
        try {
            log.info("Sending email.");

            // Creating a simple mail message
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo("accounts@gsrtechsystems.com");
            mailMessage.setCc("rajkumar.gadagotti@gsrtechsystems.com");
            mailMessage.setSubject("Daily Status Update");
            mailMessage.setText(randomMessage.returnRandomString());

            // Sending the mail
            javaMailSender.send(mailMessage);
            log.info("Email Sent");
            return "Mail Sent Successfully...";
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error message: "+e.getMessage());
            return "Error while Sending Mail";
        }
    }
}
