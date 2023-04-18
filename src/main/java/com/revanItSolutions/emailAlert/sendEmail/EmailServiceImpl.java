package com.revanItSolutions.emailAlert.sendEmail;

import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService{
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}") private String sender;
    @Override
    public String sendSimpleMail(EmailDetails details) {

        // Try block to check for exceptions
        try {
            log.info("Sending email.");

            // Creating a simple mail message
//            SimpleMailMessage mailMessage
//                    = new SimpleMailMessage();

            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            String htmlMsg = "<h1>Hello World!</h1>";
            helper.setText(htmlMsg,true);
            helper.setTo(details.getRecipient());
            helper.setSubject(details.getSubject());
            helper.setFrom(sender);
            javaMailSender.send(mimeMessage);

            // Setting up necessary details
//            mailMessage.setFrom(sender);
//
//            mailMessage.setTo(details.getRecipient());
//            mailMessage.setText(details.getMsgBody());
//            mailMessage.setSubject(details.getSubject());
//
//            // Sending the mail
//            javaMailSender.send(mailMessage);
            log.info("Email Sent");
            return "Mail Sent Successfully...";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            e.printStackTrace();
            log.error("Error message: "+e.getMessage());
            return "Error while Sending Mail";
        }
    }

    @Override
    public String sendMailWithAttachment(EmailDetails details) {
        return null;
    }
}
