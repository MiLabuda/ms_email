package com.wszib.mail.domain;

import lombok.*;
import org.springframework.mail.SimpleMailMessage;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Getter
public class Mail {

    private final MailId id;
    private final Email from;
    private final Email to;
    private final Subject subject;
    private final Url hostUrl;
    private ZonedDateTime createdAt;
    private final MailType type;
    private StatusMail status;
    private final String body;

    Mail(MailId mailId, Email emailFrom, Email emailTo, Subject subject, Url hostUrl, MailType mailType, StatusMail statusMail, String body) {
        this.id = mailId;
        this.from = emailFrom;
        this.to = emailTo;
        this.subject = subject;
        this.hostUrl = hostUrl;
        this.type = mailType;
        this.status = statusMail;
        this.body = body;
    }

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

    public SimpleMailMessage toSimpleMailMessage() {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject(subject.getValue());
        email.setText(body);
        email.setTo(to.value());
        email.setFrom(from.value());
        return email;
    }


}
