package com.wszib.mail.application.core;

import com.wszib.mail.adapters.out.SaveMailAdapter;
import com.wszib.mail.domain.EStatusMail;
import com.wszib.mail.domain.Mail;
import com.wszib.mail.application.ports.in.SendMailUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

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
            mail.setStatus(EStatusMail.SENT);
        } catch (Exception e) {
            mail.setStatus(EStatusMail.ERROR);
        }finally {
            save(mail);
        }
    }

    private void save(Mail mail) {
        mail.setCreatedAt(ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("UTC+0")));
        saveMailAdapter.save(mail);
    }
}
