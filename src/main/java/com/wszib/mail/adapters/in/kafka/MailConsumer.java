package com.wszib.mail.adapters.in.kafka;

import com.wszib.mail.application.ports.in.SendMailUseCase;
import com.wszib.mail.domain.Mail;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MailConsumer {

    private final MailMapper mailMapper;
    private final SendMailUseCase sendMailUseCase;

    @KafkaListener(
            topics = "Topic_MAIL",
            groupId = "default_id",
            containerFactory = "kafkaListenerContainerFactory")
    public void consumeMailRequest(MailRequestMessage mailRequestMessage,
                                   @Header(KafkaHeaders.RECEIVED_KEY) String key){
        Mail mail = mailMapper.mailRequestToMail(mailRequestMessage);
        sendMailUseCase.sendEmail(mail);
    }
}
