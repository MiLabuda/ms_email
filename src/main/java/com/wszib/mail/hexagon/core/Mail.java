package com.wszib.mail.hexagon.core;

import com.wszib.mail.adapters.driver.EMailType;
import jakarta.persistence.*;
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
    private String emailFrom;
    private String emailTo;
    private String subject;
    private String baseUrl;
    private ZonedDateTime sendDateEmail;
    private EMailType mailType;
    private StatusMail statusMail;

    @Transient
    private String text;
}
