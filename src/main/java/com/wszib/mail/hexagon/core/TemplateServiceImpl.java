package com.wszib.mail.hexagon.core;


import com.wszib.mail.adapters.driver.EMailType;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class TemplateServiceImpl {

    SimpleMailMessage constructEmail(String baseUrl, String mailTo, EMailType mailType) {
        return switch (mailType) {
            //TODO pass real token
            case RESET_PASSWORD -> constructResetTokenEmail(baseUrl, "token", mailTo);
            case REGISTRATION_CONFIRMATION, CONTACT_US -> null;
        };
    }

    SimpleMailMessage constructResetTokenEmail(String contextPath, String token, String mailTo) {
        String url = contextPath + "/savePassword?token=" + token;
        String message = "Click on the link below to reset your password. \r\n";
        String subject = "Reset Password";
        String body = message + " \r\n" + url;
        return constructEmail(subject, body, mailTo);
    }

    SimpleMailMessage constructEmail(String subject, String body, String mailTo) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject(subject);
        email.setText(body);
        email.setTo(mailTo);
        //TODO Implement properties table in database as well as a service to retrieve them
//        email.setFrom(env.getProperty("support.email"));
        email.setFrom("support@tyreshop24.com");
        return email;
    }
}
