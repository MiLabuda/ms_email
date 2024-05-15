package com.wszib.mail.adapters.in.web;

import com.wszib.mail.domain.EStatusMail;

import java.time.ZonedDateTime;

public record MailDTO(
        Long id,
        String emailFrom,
        String emailTo,
        String subject,
        ZonedDateTime sendDateEmail,
        EStatusMail EStatusMail
) {
}
