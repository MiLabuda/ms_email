package com.wszib.mail.adapters.out;

import com.wszib.mail.adapters.out.model.Mail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveMailAdapter {
    private final MailRepository mailRepository;

    void save(Mail mail) {
        mailRepository.save(mail);
    }

}
