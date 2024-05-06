package com.wszib.mail.adapters.driver;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;


public record MailRequestMessage(
        @NotBlank String ownerRef,
        @NotBlank @Email String emailFrom,
        @NotBlank @Email String emailTo,
        @NotBlank String subject,
        @NotBlank String text,
        @NotBlank String baseUrl,
        @NotBlank EMailType mailType
) {
}
