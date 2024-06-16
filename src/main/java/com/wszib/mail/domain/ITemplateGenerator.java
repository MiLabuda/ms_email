package com.wszib.mail.domain;

import com.wszib.mail.application.commands.SendMailCommand;

public interface ITemplateGenerator {
    String generateTemplate(SendMailCommand mailCommand);
}