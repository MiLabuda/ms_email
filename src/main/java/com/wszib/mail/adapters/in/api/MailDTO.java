package com.wszib.mail.adapters.in.api;

import com.wszib.mail.domain.EStatusMail;
import com.wszib.mail.domain.Mail;

import java.time.ZonedDateTime;

public record MailDTO(
        Long id,
        String emailFrom,
        String emailTo,
        String subject,
        ZonedDateTime sendDateEmail,
        EStatusMail EStatusMail
) {
    MailDTO of(Mail mail){
        return new MailDTO(
                mail.getId(),
                mail.getEmailFrom(),
                mail.getEmailTo(),
                mail.getSubject(),
                mail.getCreatedAt(),
                mail.getStatus()
        );
    }
}
