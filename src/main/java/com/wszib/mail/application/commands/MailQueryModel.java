package com.wszib.mail.application.commands;

import java.time.Instant;

public record MailQueryModel(
        String id,
        String emailFrom,
        String emailTo,
        String subject,
        String hostUrl,
        Instant createdAt,
        String status
) {

}
