package com.wszib.mail.adapters.out;

import com.wszib.mail.application.ports.out.GetMailPort;
import com.wszib.mail.domain.Mail;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class GetMailAdapter implements GetMailPort {
    private final MailRepository mailRepository;
    private final MailRepositoryMapper mapper;

    public Mail findById(Long id) {
        return mapper.mapToDomainEntity(mailRepository.findById(id));
    }

    public Page<Mail> findAll(Pageable pageable) {
        return mapper.mapToDomainEntityPage(mailRepository.findAll(pageable));
    }
}
