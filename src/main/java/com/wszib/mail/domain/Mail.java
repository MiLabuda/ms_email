package com.wszib.mail.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Mail {

    public enum StatusMail {
        SENT,
        ERROR,
        PENDING
    }

    public enum MailType {
        RESET_PASSWORD,
        REGISTRATION_CONFIRMATION,
        CONTACT_US
    }

    private MailId id;
    private Email from;
    private Email to;

    @NotBlank
    private String subject;

    @NotBlank
    private String baseUrl;

    @NotBlank
    private ZonedDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @NotBlank
    private MailType type;

    @NotBlank
    private StatusMail status;

    private String text;


}
