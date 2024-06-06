package com.wszib.mail.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.time.ZonedDateTime;

@Getter
@RequiredArgsConstructor
public class Mail {

    private final MailId id;
    private final Email from;
    private final Email to;

    @NotBlank
    private final String subject;

    @NotBlank
    private final String baseUrl;

    @NotBlank
    private final ZonedDateTime createdAt;

    private final MailType type;

    private final StatusMail status;

    private final String text;
}
