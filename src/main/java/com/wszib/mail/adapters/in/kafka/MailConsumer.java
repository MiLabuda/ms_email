package com.wszib.mail.adapters.in.kafka;

import com.wszib.mail.domain.Mail;
import com.wszib.mail.hexagon.ports.driver.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MailConsumer {

    private final MailMapper mailMapper;
    private final MailService mailService;

//    @Transactional
    @KafkaListener(
            topics = "Topic_MAIL",
            groupId = "default_id",
            containerFactory = "kafkaListenerContainerFactory")
    public void consumeMailRequest(MailRequestMessage mailRequestMessage,
                                   @Header(KafkaHeaders.RECEIVED_KEY) String key){
        Mail mail = mailMapper.mailRequestToMail(mailRequestMessage);
        mailService.sendEmail(mail);
    }
}
