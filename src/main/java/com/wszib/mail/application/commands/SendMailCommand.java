package com.wszib.mail.application.commands;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record SendMailCommand(
        @NotBlank @Email String emailTo,
        @NotBlank @Email String emailFrom,
        @NotBlank String message,
        @NotBlank String baseUrl,
        @NotBlank String mailType
) {
}