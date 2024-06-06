package com.wszib.mail.domain;

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

    private MailId id;
    private Email from;
    private Email to;

    @NotBlank
    private String subject;

    @NotBlank
    private String baseUrl;

    @NotBlank
    private ZonedDateTime createdAt;

    private MailType type;

    @NotBlank
    private StatusMail status;

    private String text;
}
