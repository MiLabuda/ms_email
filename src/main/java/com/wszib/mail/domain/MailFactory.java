package com.wszib.mail.domain;

import com.wszib.mail.application.commands.SendMailCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
class MailFactory implements IMailFactory {

    public static final String MAIL_TYPE_RESET_PASSWORD = "Reset Password";
    public static final String MAIL_TYPE_CONFIRM_REGISTRATION = "Confirm registration";
    public static final String PATH_SAVE_PASSWORD_PATH_WITH_TOKEN_PARAMETER = "/savePassword?token=";
    public static final String PATH_AUTH_CONFIRM_PATH_WITH_TOKEN_PARAMETER = "/auth/confirm?token=";
    public static final String SUBJECT_RESET_PASSWORD = "Reset Password";
    public static final String SUBJECT_CONFIRM_REGISTRATION = "Confirm registration";

    ITemplateGenerator mailTemplateGenerator;

    @Override
    public Mail createMail(SendMailCommand command) {
        return switch (command.mailType()) {
            case  MAIL_TYPE_RESET_PASSWORD-> createResetPasswordMail(command);
            case MAIL_TYPE_CONFIRM_REGISTRATION -> createRegistrationConfirmationMail(command);
            // add more cases as needed
            default -> throw new IllegalArgumentException("Unsupported mail type: " + command.mailType());
        };
    }

    private Mail createResetPasswordMail(SendMailCommand command) {
        Url baseUrl = new Url(command.baseUrl());
        Url resetPasswordUrl = new Url(baseUrl.getValue() + PATH_SAVE_PASSWORD_PATH_WITH_TOKEN_PARAMETER + command.message());
        Subject subject = new Subject(SUBJECT_RESET_PASSWORD);
        MailType mailType = MailType.RESET_PASSWORD;
        return createMail(command, subject, resetPasswordUrl, mailType);
    }

    private Mail createRegistrationConfirmationMail(SendMailCommand command) {
        Url baseUrl = new Url(command.baseUrl());
        Url confirmRegistrationUrl = new Url(baseUrl.getValue() + PATH_AUTH_CONFIRM_PATH_WITH_TOKEN_PARAMETER + command.message());
        Subject subject = new Subject(SUBJECT_CONFIRM_REGISTRATION);
        MailType mailType = MailType.REGISTRATION_CONFIRMATION;
        return createMail(command, subject, confirmRegistrationUrl, mailType);
    }

    private Mail createMail(SendMailCommand command, Subject subject, Url hostUrl, MailType mailType) {
        return new Mail(
                //TODO: generate a random id
                new MailId(UUID.randomUUID().toString()),
                new Email(command.emailFrom()),
                new Email(command.emailTo()),
                subject,
                hostUrl,
                mailType,
                StatusMail.PENDING,
                mailTemplateGenerator.generateTemplate(command));
    }

}
