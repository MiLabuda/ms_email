package com.wszib.mail.adapters.out.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mails")
public class MailData {
    @Id
    private String id;

    @NotBlank
    private String emailFrom;

    @NotBlank
    private String emailTo;

    @NotBlank
    private String subject;

    @NotBlank
    private String baseUrl;

    @NotBlank
    private Instant sendDateEmail;

    @NotBlank
    private String mailType;

    @NotBlank
    private String status;
}
