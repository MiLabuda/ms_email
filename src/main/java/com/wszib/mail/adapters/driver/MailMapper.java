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
                mail.getOwnerRef(),
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
        mail.setOwnerRef(mailRequestMessage.ownerRef());
        mail.setEmailFrom(mailRequestMessage.emailFrom());
        mail.setEmailTo(mailRequestMessage.emailTo());
        mail.setSubject(mailRequestMessage.subject());
        mail.setText(mailRequestMessage.text());
        mail.setBaseUrl(mailRequestMessage.baseUrl());
        mail.setMailType(mailRequestMessage.mailType());
        return mail;
    }

}
