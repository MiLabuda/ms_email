package com.wszib.mail.adapters.driver;

import com.wszib.mail.hexagon.core.IdGenerator;
import com.wszib.mail.hexagon.core.Mail;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MailMapper {

    public List<MailDTO> mailListToMailDTOList(List<Mail> mailList) {
        return mailList.stream()
                .map(this::mailToMailDTO)
                .toList();
    }

    public MailDTO mailToMailDTO(Mail mail) {
        return new MailDTO(
                mail.getId(),
                mail.getEmailFrom(),
                mail.getEmailTo(),
                mail.getSubject(),
                mail.getSendDateEmail(),
                mail.getStatusMail()
        );
    }

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
