package com.wszib.mail.adapters.in.kafka;

import com.wszib.mail.infrastructure.utils.IdGenerator;
import com.wszib.mail.domain.Mail;
import org.springframework.stereotype.Component;

@Component
public class MailMapper {

    public Mail mailRequestToMail(MailRequestMessage mailRequestMessage) {
        Mail mail = new Mail();
        mail.setId(IdGenerator.generateId());
        mail.setEmailTo(mailRequestMessage.emailTo());
        mail.setText(mailRequestMessage.text());
        mail.setBaseUrl(mailRequestMessage.baseUrl());
        mail.setMailType(mailRequestMessage.mailType());
        return mail;
    }
}
