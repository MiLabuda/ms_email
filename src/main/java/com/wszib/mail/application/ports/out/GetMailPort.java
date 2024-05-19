package com.wszib.mail.application.ports.out;

import com.wszib.mail.domain.Mail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface GetMailPort {

    Mail findById(Long id);
    Page<Mail> findAll(Pageable pageable);
}
