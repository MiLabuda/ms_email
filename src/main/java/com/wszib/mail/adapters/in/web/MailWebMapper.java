package com.wszib.mail.adapters.in.web;

import com.wszib.mail.domain.Mail;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MailWebMapper {

    List<MailDTO> mailListToMailDTOList(List<Mail> mailList) {
        return mailList.stream()
                .map(this::mailToMailDTO)
                .toList();
    }

    MailDTO mailToMailDTO(Mail mail) {
        return new MailDTO(
                mail.getId(),
                mail.getEmailFrom(),
                mail.getEmailTo(),
                mail.getSubject(),
                mail.getSendDateEmail(),
                mail.getEStatusMail()
        );
    }
}
