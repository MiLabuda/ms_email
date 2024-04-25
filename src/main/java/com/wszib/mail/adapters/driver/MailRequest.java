package com.wszib.mail.adapters.driver;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

public record MailRequest(
        @NotBlank String ownerRef,
        @NotBlank @Email String emailFrom,
        @NotBlank @Email String emailTo,
        @NotBlank String subject,
        @NotBlank String text
) {
}
