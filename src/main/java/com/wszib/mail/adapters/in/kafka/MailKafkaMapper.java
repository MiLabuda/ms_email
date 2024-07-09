package com.wszib.mail.adapters.in.kafka;

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
                mailRequestMessage.message(),
                mailRequestMessage.baseUrl(),
                mailRequestMessage.mailType()
        );
    }
}
