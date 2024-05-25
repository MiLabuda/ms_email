package com.wszib.mail.adapters.in.api;

import com.wszib.mail.domain.Mail;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MailWebMapper {

    Page<MailDTO> mailPageToMailDTOPage(Page<Mail> mailPage) {
        return mailPage.map(this::mailToMailDTO);
    }

    List<MailDTO> mailListToMailDTOList(List<Mail> mailList) {
        return mailList.stream()
                .map(this::mailToMailDTO)
                .toList();
    }

    MailDTO mailToMailDTO(Mail mail) {
        return new MailDTO(
                mail.getId(),
                mail.getEmailFrom(),
                mail.getEmailTo(),
                mail.getSubject(),
                mail.getCreatedAt(),
                mail.getStatus()
        );
    }
}
