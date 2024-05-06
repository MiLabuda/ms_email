package com.wszib.mail.hexagon.core;


import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class TemplateServiceImpl {

    SimpleMailMessage constructEmail(Mail mail) {
        return switch (mail.getMailType()) {
            //TODO pass real token
            case RESET_PASSWORD -> constructResetTokenEmail(mail);
            case REGISTRATION_CONFIRMATION, CONTACT_US -> null;
        };
    }

    SimpleMailMessage constructResetTokenEmail(Mail mail) {
        String url = mail.getBaseUrl() + "/savePassword?token=" + mail.getText();
        String message = "Click on the link below to reset your password. \r\n";
        String subject = "Reset Password";
        String body = message + " \r\n" + url;
        mail.setText(body);
        mail.setSubject(subject);
        //TODO Implement properties table in database as well as a service to retrieve them
//        email.setFrom(env.getProperty("support.email"));
        String hostEmail = "support@tyreshop24.com";
        mail.setEmailFrom(hostEmail);
        return constructSimpleMailMessage(mail);
    }

    SimpleMailMessage constructSimpleMailMessage(Mail mail) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject(mail.getSubject());
        email.setText(mail.getText());
        email.setTo(mail.getEmailTo());
        email.setFrom(mail.getEmailFrom());
        return email;
    }
}
