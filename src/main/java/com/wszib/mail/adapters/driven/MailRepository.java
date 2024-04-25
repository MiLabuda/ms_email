package com.wszib.mail.adapters.driven;

import com.wszib.mail.hexagon.core.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailRepository extends JpaRepository<Mail, Long> {

}
