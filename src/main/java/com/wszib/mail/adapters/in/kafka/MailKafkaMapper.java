package com.wszib.mail.adapters.in.kafka;

import com.wszib.mail.application.commands.EMailType;
import com.wszib.mail.application.commands.MessageValue;
import com.wszib.mail.application.commands.SendMailCommand;
import com.wszib.mail.infrastructure.config.MailProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class MailKafkaMapper {

    MailProperties mailProperties;

    SendMailCommand mailRequestToCommand(MailRequestMessage mailRequestMessage) {
        return new SendMailCommand(
                mailRequestMessage.emailTo(),
                mailProperties.getHostMail(),
                new MessageValue(mailRequestMessage.message()),
                mailRequestMessage.baseUrl(),
                EMailType.valueOf(mailRequestMessage.mailType())
        );
    }
}
