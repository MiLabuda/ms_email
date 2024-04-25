package com.wszib.mail.adapters.driver;

import com.wszib.mail.hexagon.core.StatusMail;

import java.time.Instant;

public record MailDTO(
        Long id,
        String ownerRef,
        String emailFrom,
        String emailTo,
        String subject,
        String text,
        Instant sendDateEmail,
        StatusMail statusMail
) {
}
