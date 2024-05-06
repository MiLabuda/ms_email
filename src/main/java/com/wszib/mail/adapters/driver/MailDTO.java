package com.wszib.mail.adapters.driver;

import com.wszib.mail.hexagon.core.StatusMail;

import java.time.ZonedDateTime;

public record MailDTO(
        Long id,
        String emailFrom,
        String emailTo,
        String subject,
        ZonedDateTime sendDateEmail,
        StatusMail statusMail
) {
}
