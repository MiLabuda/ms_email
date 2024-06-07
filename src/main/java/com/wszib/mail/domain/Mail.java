package com.wszib.mail.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Getter
@RequiredArgsConstructor
public class Mail {

    private final MailId id;
    private final Email from;
    private final Email to;
    private final Subject subject;
    private final Url hostUrl;
    private ZonedDateTime createdAt;
    private final MailType type;
    private StatusMail status;
    private final String text;

    public void markAsSent() {
        this.status = StatusMail.SENT;
    }

    public void markAsError() {
        this.status = StatusMail.ERROR;
    }

    public void markAsPending() {
        this.status = StatusMail.PENDING;
    }

    public void setCreationDateAsNow() {
        this.createdAt = ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("UTC+0"));
    }

}
