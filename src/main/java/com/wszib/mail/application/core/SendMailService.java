package com.wszib.mail.application.core;

import com.wszib.mail.adapters.out.SaveMailAdapter;
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
    private final TemplateServiceImpl templateServiceImpl;
    private final SaveMailAdapter saveMailAdapter;

    @Override
    @Transactional
    public void sendEmail(Mail mail) {
        SimpleMailMessage message = templateServiceImpl.constructEmail(mail);
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
