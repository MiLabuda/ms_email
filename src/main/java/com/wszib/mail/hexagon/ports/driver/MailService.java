package com.wszib.mail.hexagon.ports.driver;

import com.wszib.mail.hexagon.core.Mail;
import com.wszib.mail.adapters.driver.MailRequestMessage;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MailService {
    void sendEmail(Mail mail);
    List<Mail> findAll(Pageable pageable);
    Mail findById(Long id);
}
