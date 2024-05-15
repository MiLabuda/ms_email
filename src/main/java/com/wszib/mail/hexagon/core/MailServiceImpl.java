package com.wszib.mail.hexagon.core;

import com.wszib.mail.adapters.out.MailRepository;
import com.wszib.mail.domain.Mail;
import com.wszib.mail.domain.EStatusMail;
import com.wszib.mail.hexagon.ports.driver.MailService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

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

    @Override
    public List<Mail> findAll(Pageable pageable) {
        return mailRepository.findAll(pageable).getContent();
    }

    @Override
    public Mail findById(Long id) {
        return mailRepository.findById(id).orElseThrow(() -> new RuntimeException("Mail not found"));
    }
}
