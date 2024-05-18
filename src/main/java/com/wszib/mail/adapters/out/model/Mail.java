package com.wszib.mail.adapters.out.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mails")
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
    private com.wszib.mail.adapters.out.model.EStatusMail EStatusMail;

    @Transient
    private String text;
}
