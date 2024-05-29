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

    private Long id;

    @NotBlank
    private String emailFrom;

    @NotBlank
    private String emailTo;

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
