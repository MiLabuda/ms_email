package com.wszib.mail.adapters.out;

import com.wszib.mail.application.commands.MailQueryModel;
import com.wszib.mail.application.ports.out.GetMailPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetMailAdapter implements GetMailPort {
    private final MailRepository mailRepository;
    private final MailRepositoryMapper mapper;

    public MailQueryModel findById(Long id) {
        return mapper.mapToQueryModel(mailRepository.findById(id));
    }

    public Page<MailQueryModel> findAll(Pageable pageable) {
        return mapper.mapToQueryModelPage(mailRepository.findAll(pageable));
    }
}
