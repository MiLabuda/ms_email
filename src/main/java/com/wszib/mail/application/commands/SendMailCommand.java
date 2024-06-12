package com.wszib.mail.application.commands;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record SendMailCommand(
        @NotBlank @Email String emailTo,
        @NotBlank MessageValue message,
        @NotBlank String baseUrl,
        @NotBlank EMailType mailType
) {
}