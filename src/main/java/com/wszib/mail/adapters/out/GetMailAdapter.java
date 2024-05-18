package com.wszib.mail.adapters.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetMailAdapter {
    private final MailRepository mailRepository;

    void findMail(Long id) {
        mailRepository.findById(id);
    }

    void findAll() {
        mailRepository.findAll();
    }
}
