package com.wszib.mail.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mail.SimpleMailMessage;

import java.time.Instant;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class MailTest {

    private Mail mail;

    @BeforeEach
    void setUp() {
        mail = new Mail(
                new MailId("1"),
                new Email("from@example.com"),
                new Email("to@example.com"),
                new Subject("subject"),
                new Url("http://localhost"),
                MailType.RESET_PASSWORD,
                StatusMail.PENDING,
                "body"
        );
    }

    @Test
    @DisplayName("When marked as sent, status is SENT")
    void markAsSent() {
        mail.markAsSent();
        assertEquals(StatusMail.SENT, mail.getStatus());
    }

    @Test
    @DisplayName("When marked as error, status is ERROR")
    void markAsError() {
        mail.markAsError();
        assertEquals(StatusMail.ERROR, mail.getStatus());
    }

    @Test
    @DisplayName("When marked as pending, status is PENDING")
    void markAsPending() {
        mail.markAsPending();
        assertEquals(StatusMail.PENDING, mail.getStatus());
    }

    @Test
    @DisplayName("When creation date is set as now, creation date is current time")
    void setCreationDateAsNow() {
        mail.setCreationDateAsNow();
        assertTrue(Instant.now().minusSeconds(1).isBefore(mail.getCreatedAt()));
        assertTrue(Instant.now().plusSeconds(1).isAfter(mail.getCreatedAt()));
    }

    @Test
    @DisplayName("When converted to SimpleMailMessage, returns expected SimpleMailMessage")
    void toSimpleMailMessage() {
        SimpleMailMessage simpleMailMessage = mail.toSimpleMailMessage();
        assertEquals(mail.getSubject().value(), simpleMailMessage.getSubject());
        assertEquals(mail.getBody(), simpleMailMessage.getText());
        assertEquals(mail.getTo().value(), Objects.requireNonNull(simpleMailMessage.getTo())[0]);
        assertEquals(mail.getFrom().value(), simpleMailMessage.getFrom());
    }
}