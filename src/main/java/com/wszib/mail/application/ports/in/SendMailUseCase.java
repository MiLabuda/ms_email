package com.wszib.mail.application.ports.in;

import com.wszib.mail.domain.Mail;

public interface SendMailUseCase {

    void sendEmail(SendMailCommand mailCommand);

}
