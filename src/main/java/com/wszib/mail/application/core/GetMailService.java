package com.wszib.mail.application.core;

import com.wszib.mail.adapters.out.MailRepository;
import com.wszib.mail.domain.Mail;
import com.wszib.mail.application.ports.in.GetMailUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetMailService implements GetMailUseCase {

    private final MailRepository mailRepository;

    @Override
    public List<Mail> findAll(Pageable pageable) {
        return mailRepository.findAll(pageable).getContent();
    }

    @Override
    public Mail findById(Long id) {
        return mailRepository.findById(id).orElseThrow(() -> new RuntimeException("Mail not found"));
    }
}
