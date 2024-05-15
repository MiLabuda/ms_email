package com.wszib.mail.hexagon.ports.driver;

import com.wszib.mail.domain.Mail;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MailService {
    void sendEmail(Mail mail);
    List<Mail> findAll(Pageable pageable);
    Mail findById(Long id);
}
