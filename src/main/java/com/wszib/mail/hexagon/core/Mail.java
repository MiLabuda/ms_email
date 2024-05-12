package com.wszib.mail.hexagon.core;

import com.wszib.mail.adapters.driver.EMailType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
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

    @NotNull
    @NotEmpty
    private String emailFrom;

    @NotNull
    @NotEmpty
    private String emailTo;

    @NotNull
    @NotEmpty
    private String subject;

    @NotNull
    @NotEmpty
    private String baseUrl;

    @NotNull
    @NotEmpty
    private ZonedDateTime sendDateEmail;

    @Enumerated(EnumType.STRING)
    private EMailType mailType;

    @NotNull
    @NotEmpty
    private StatusMail statusMail;

    @Transient
    private String text;
}
