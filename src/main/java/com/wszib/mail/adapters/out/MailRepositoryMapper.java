package com.wszib.mail.adapters.out;

import com.wszib.mail.adapters.out.model.MailData;
import com.wszib.mail.domain.Mail;
import com.wszib.mail.infrastructure.exceptions.MailNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MailRepositoryMapper {

    Mail mapToDomainEntity (Optional<MailData> mailDataOptional){
        MailData mailData = mailDataOptional.orElseThrow(MailNotFoundException::new);
        return new Mail(
                mailData.getId(),
                mailData.getEmailFrom(),
                mailData.getEmailTo(),
                mailData.getSubject(),
                mailData.getBaseUrl(),
                mailData.getSendDateEmail(),
                EMailType.valueOf(mailData.getMailType()),
                EStatusMail.valueOf(mailData.getStatus()),
                mailData.getText()

        );
    }

    Page<Mail> mapToDomainEntityPage(Page<MailData> mailDataPage){
        return mailDataPage.map(mailData -> new Mail(
                mailData.getId(),
                mailData.getEmailFrom(),
                mailData.getEmailTo(),
                mailData.getSubject(),
                mailData.getBaseUrl(),
                mailData.getSendDateEmail(),
                EMailType.valueOf(mailData.getMailType()),
                EStatusMail.valueOf(mailData.getStatus()),
                mailData.getText()
        ));
    }

    MailData mapToJpaEntity(Mail mail){
        return new MailData(
                mail.getId(),
                mail.getEmailFrom(),
                mail.getEmailTo(),
                mail.getSubject(),
                mail.getBaseUrl(),
                mail.getCreatedAt(),
                mail.getType().name(),
                mail.getStatus().name(),
                mail.getText()
        );
    }

}
