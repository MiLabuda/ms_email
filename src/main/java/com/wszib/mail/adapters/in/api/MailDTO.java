package com.wszib.mail.adapters.in.api;

import com.wszib.mail.domain.Mail;

import java.time.ZonedDateTime;

public record MailDTO(
        String id,
        String emailFrom,
        String emailTo,
        String subject,
        ZonedDateTime sendDateEmail,
        String EStatusMail
) {
    MailDTO of(Mail mail){
        return new MailDTO(
                mail.getId().value(),
                mail.getFrom().value(),
                mail.getTo().value(),
                mail.getSubject().value(),
                mail.getCreatedAt(),
                mail.getStatus().value()
        );
    }
}
