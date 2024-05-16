package com.wszib.mail.application.ports.in;

import com.wszib.mail.domain.Mail;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GetMailUseCase {

    List<Mail> findAll(Pageable pageable);

    Mail findById(Long id);
}
