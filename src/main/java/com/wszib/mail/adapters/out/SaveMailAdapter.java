package com.wszib.mail.adapters.out;

import com.wszib.mail.adapters.out.model.MailData;
import com.wszib.mail.application.ports.out.SaveMailPort;
import com.wszib.mail.domain.Mail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveMailAdapter implements SaveMailPort {
    private final MailRepository mailRepository;
    private final MailRepositoryMapper mapper;

    public void save(Mail mail) {

        MailData mailData = mapper.mapToJpaEntity(mail);
        mailRepository.save(mailData);
    }

}
