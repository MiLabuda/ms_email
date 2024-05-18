package com.wszib.mail.application.ports.out;

import com.wszib.mail.domain.Mail;

public interface SaveMailPort {

    void save(Mail mail);
}
