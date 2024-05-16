package com.wszib.mail.application.core;

import com.wszib.mail.adapters.out.MailRepository;
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
    private final MailRepository mailRepository;
    private final TemplateServiceImpl templateServiceImpl;

    @Override
    @Transactional
    public void sendEmail(Mail mail) {
        SimpleMailMessage message = templateServiceImpl.constructEmail(mail);
        try {
            javaMailSender.send(message);
            mail.setEStatusMail(EStatusMail.SENT);
        } catch (Exception e) {
            mail.setEStatusMail(EStatusMail.ERROR);
        }finally {
            save(mail);
        }
    }

    private void save(Mail mail) {
        mail.setSendDateEmail(ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("UTC+0")));
        mailRepository.save(mail);
    }
}
