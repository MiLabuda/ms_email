package com.wszib.mail.domain;

import com.wszib.mail.application.commands.SendMailCommand;

public interface IMailFactory {
    Mail createMail(SendMailCommand command);
}