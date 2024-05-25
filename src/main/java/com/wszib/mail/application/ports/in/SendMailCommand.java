package com.wszib.mail.application.ports.in;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;

import java.time.ZonedDateTime;

@RequiredArgsConstructor
public class SendMailCommand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private ZonedDateTime sendDateEmail;

    @Enumerated(EnumType.STRING)
    @NotBlank
    private EMailType mailType;

    @NotBlank
    private EStatusMail EStatusMail;

    @Transient
    private String text;

    enum EStatusMail {
        SENT,
        ERROR
    }

    enum EMailType {
        RESET_PASSWORD,
        REGISTRATION_CONFIRMATION,
        CONTACT_US
    }
}
