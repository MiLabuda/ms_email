package com.wszib.mail.application.core;

import com.wszib.mail.adapters.out.SaveMailAdapter;
import com.wszib.mail.application.commands.SendMailCommand;
import com.wszib.mail.domain.IMailFactory;
import com.wszib.mail.domain.Mail;
import com.wszib.mail.application.ports.in.SendMailUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendMailService implements SendMailUseCase {

    private final JavaMailSender javaMailSender;
    private final SaveMailAdapter saveMailAdapter;
    private final IMailFactory mailFactory;

    @Override
    @Transactional
    public void sendEmail(SendMailCommand mailCommand) {
        Mail mail = mailFactory.createMail(mailCommand);

        SimpleMailMessage message = mail.toSimpleMailMessage();
        try {
            javaMailSender.send(message);
            mail.markAsSent();
        } catch (Exception e) {
            mail.markAsError();
        }
        save(mail);

    }

    public void save(Mail mail) {
        mail.setCreationDateAsNow();
        saveMailAdapter.save(mail);
    }
}
