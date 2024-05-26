package com.wszib.mail.adapters.in.kafka;

import com.wszib.mail.domain.Mail;
import com.wszib.mail.infrastructure.config.MailProperties;
import com.wszib.mail.infrastructure.utils.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MailKafkaMapper {

    private final MailProperties mailProperties;

    public Mail mailRequestToMail(MailRequestMessage mailRequestMessage) {
            Mail mail = new Mail();
            mail.setId(IdGenerator.generateId());
            mail.setEmailFrom(mailProperties.getHostMail());
            mail.setEmailTo(mailRequestMessage.emailTo());
            mail.setType(EMailType.valueOf(String.valueOf(mailRequestMessage.mailType())));

            return mail;
        }

}
