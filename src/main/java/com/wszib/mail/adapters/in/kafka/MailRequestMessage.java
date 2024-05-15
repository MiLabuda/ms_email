package com.wszib.mail.adapters.in.kafka;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;


public record MailRequestMessage(
        @NotBlank @Email String emailTo,
        @NotBlank String text,
        @NotBlank String baseUrl,
        @NotBlank EMailType mailType
) {
}
