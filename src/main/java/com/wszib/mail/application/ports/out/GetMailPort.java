package com.wszib.mail.application.ports.out;

import com.wszib.mail.application.commands.MailQueryModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface GetMailPort {

    MailQueryModel findById(Long id);
    Page<MailQueryModel> findAll(Pageable pageable);
}
