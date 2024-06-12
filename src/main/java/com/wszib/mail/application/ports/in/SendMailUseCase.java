package com.wszib.mail.application.ports.in;

import com.wszib.mail.application.commands.SendMailCommand;

public interface SendMailUseCase {

    void sendEmail(SendMailCommand mailCommand);

}
