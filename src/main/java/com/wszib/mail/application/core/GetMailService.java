package com.wszib.mail.application.core;

import com.wszib.mail.adapters.out.GetMailAdapter;
import com.wszib.mail.application.ports.in.GetMailUseCase;
import com.wszib.mail.domain.Mail;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class GetMailService implements GetMailUseCase {

    private final GetMailAdapter getMailAdapter;

    @Override
    public Page<Mail> findAll(Pageable pageable) {
        return getMailAdapter.findAll(pageable);
    }

    @Override
    public Mail findById(Long id) {
        return getMailAdapter.findById(id);
    }
}
