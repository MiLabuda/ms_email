package com.wszib.mail.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Mail {
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
}
