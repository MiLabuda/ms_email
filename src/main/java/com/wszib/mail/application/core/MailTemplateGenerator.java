package com.wszib.mail.application.core;


import com.wszib.mail.application.commands.SendMailCommand;
import com.wszib.mail.domain.ITemplateGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@RequiredArgsConstructor
public class MailTemplateGenerator implements ITemplateGenerator {

    public static final String MAIL_TYPE_RESET_PASSWORD = "Reset Password";
    public static final String MAIL_TYPE_CONFIRM_REGISTRATION = "Confirm registration";
    public static final String MAIL_CONTACT_US = "Contact us";

    private final TemplateEngine templateEngine;

    public String generateTemplate(SendMailCommand mailCommand) {
        return switch (mailCommand.mailType()) {
            case MAIL_TYPE_RESET_PASSWORD -> generateResetPasswordTemplate(mailCommand);
            case MAIL_TYPE_CONFIRM_REGISTRATION -> generateRegistrationConfirmationTemplate(mailCommand);
            // add more cases as needed
            case MAIL_CONTACT_US -> null;
            default -> throw new IllegalArgumentException("Unsupported mail type: " + mailCommand.mailType());
        };
    }

    private String generateResetPasswordTemplate(SendMailCommand mailCommand) {
        Context context = new Context();
        context.setVariable("resetPasswordUrl", mailCommand.baseUrl());
        return templateEngine.process("resetPassword", context);
    }

    private String generateRegistrationConfirmationTemplate(SendMailCommand mailCommand) {
        Context context = new Context();
        context.setVariable("registrationConfirmationUrl", mailCommand.baseUrl());
        return templateEngine.process("registrationConfirmation", context);}

}
