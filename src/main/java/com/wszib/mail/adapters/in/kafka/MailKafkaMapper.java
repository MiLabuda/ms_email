package com.wszib.mail.adapters.in.kafka;

import com.wszib.mail.application.commands.EMailType;
import com.wszib.mail.application.commands.MessageValue;
import com.wszib.mail.application.commands.SendMailCommand;
import org.springframework.stereotype.Component;

@Component
class MailKafkaMapper {

    SendMailCommand mailRequestToCommand(MailRequestMessage mailRequestMessage) {
        return new SendMailCommand(
                mailRequestMessage.emailTo(),
                new MessageValue(mailRequestMessage.message()),
                mailRequestMessage.baseUrl(),
                EMailType.valueOf(mailRequestMessage.mailType())
        );
    }
}
