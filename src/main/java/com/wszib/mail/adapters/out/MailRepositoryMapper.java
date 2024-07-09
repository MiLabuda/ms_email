package com.wszib.mail.adapters.out;

import com.wszib.mail.adapters.out.model.MailData;
import com.wszib.mail.application.commands.MailQueryModel;
import com.wszib.mail.domain.Mail;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MailRepositoryMapper {

    MailQueryModel mapToQueryModel(Optional<MailData> mailDataOptional){
        //TODO Implement
        return null;
    }

    Page<MailQueryModel> mapToQueryModelPage(Page<MailData> mailDataPage){
        //TODO Implement
        return null;
    }

    MailData mapToJpaEntity(Mail mail){
        return new MailData(
                mail.getId().value(),
                mail.getFrom().value(),
                mail.getTo().value(),
                mail.getSubject().getValue(),
                mail.getHostUrl().getValue(),
                mail.getCreatedAt(),
                mail.getType().getValue(),
                mail.getStatus().getValue());
    }

}
