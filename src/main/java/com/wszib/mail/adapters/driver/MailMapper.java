package com.wszib.mail.adapters.driver;

import com.wszib.mail.hexagon.core.Mail;

import java.util.List;

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
                mail.getText(),
                mail.getSendDateEmail(),
                mail.getStatusMail()
        );
    }



}
