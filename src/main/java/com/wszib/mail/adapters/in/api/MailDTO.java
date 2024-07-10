package com.wszib.mail.adapters.in.api;

import com.wszib.mail.application.commands.MailQueryModel;

import java.time.Instant;

public record MailDTO(
        String id,
        String emailFrom,
        String emailTo,
        String subject,
        Instant sendDateEmail,
        String EStatusMail
) {
    MailDTO of(MailQueryModel mailQueryModel){
        return new MailDTO(
                mailQueryModel.id(),
                mailQueryModel.emailFrom(),
                mailQueryModel.emailTo(),
                mailQueryModel.subject(),
                mailQueryModel.createdAt(),
                mailQueryModel.status()
        );
    }
}
