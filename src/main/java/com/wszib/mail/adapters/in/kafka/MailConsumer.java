package com.wszib.mail.adapters.in.kafka;

import com.wszib.mail.application.commands.SendMailCommand;
import com.wszib.mail.application.ports.in.SendMailUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MailConsumer {

    private final MailKafkaMapper mapper;
    private final SendMailUseCase sendMailUseCase;

    @KafkaListener(
            topics = "Topic_MAIL",
            groupId = "default_id",
            containerFactory = "kafkaListenerContainerFactory")
    public void consumeMailRequest(MailRequestMessage mailRequestMessage,
                                   @Header(KafkaHeaders.RECEIVED_KEY) String key){
        SendMailCommand mailCommand = mapper.mailRequestToCommand(mailRequestMessage);
        sendMailUseCase.sendEmail(mailCommand);
    }
}
