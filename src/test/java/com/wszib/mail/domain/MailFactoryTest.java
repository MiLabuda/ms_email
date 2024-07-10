package com.wszib.mail.domain;

import com.wszib.mail.application.commands.SendMailCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class MailFactoryTest {

    @Mock
    private ITemplateGenerator templateGenerator;

    private MailFactory mailFactory;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mailFactory = new MailFactory(templateGenerator);
    }

    @Nested
    @DisplayName("Mail creation tests")
    class MailCreationTests {

        @Test
        @DisplayName("When creating reset password mail, returns expected mail")
        void createResetPasswordMail() {
            // Arrange
            SendMailCommand command = new SendMailCommand("to@example.com", "from@example.com", "message", "http://localhost", MailFactory.MAIL_TYPE_RESET_PASSWORD);
            when(templateGenerator.generateTemplate(any())).thenReturn("body");

            // Act
            Mail mail = mailFactory.createMail(command);

            // Assert
            assertEquals(StatusMail.PENDING, mail.getStatus());
            assertEquals("body", mail.getBody());
            assertEquals("Reset Password", mail.getSubject().value());
        }

        @Test
        @DisplayName("When creating registration confirmation mail, returns expected mail")
        void createRegistrationConfirmationMail() {
            // Arrange
            SendMailCommand command = new SendMailCommand("to@example.com", "from@example.com", "message", "http://localhost", MailFactory.MAIL_TYPE_CONFIRM_REGISTRATION);
            when(templateGenerator.generateTemplate(any())).thenReturn("body");

            // Act
            Mail mail = mailFactory.createMail(command);

            // Assert
            assertEquals(StatusMail.PENDING, mail.getStatus());
            assertEquals("body", mail.getBody());
            assertEquals("Confirm registration", mail.getSubject().value());
        }

        @Test
        @DisplayName("When creating mail with unsupported type, throws exception")
        void createMailWithUnsupportedType() {
            // Arrange
            SendMailCommand command = new SendMailCommand("to@example.com", "from@example.com", "message", "http://localhost", "unsupported");

            // Act & Assert
            assertThrows(IllegalArgumentException.class, () -> mailFactory.createMail(command));
        }
    }
}