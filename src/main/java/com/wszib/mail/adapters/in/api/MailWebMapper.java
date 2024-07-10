package com.wszib.mail.adapters.in.api;

import com.wszib.mail.application.commands.MailQueryModel;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MailWebMapper {

    Page<MailDTO> mailPageToMailDTOPage(Page<MailQueryModel> mailPage) {
        return mailPage.map(this::mailQueryModelToMailDTO);
    }

    List<MailDTO> mailListToMailDTOList(List<MailQueryModel> mailList) {
        return mailList.stream()
                .map(this::mailQueryModelToMailDTO)
                .toList();
    }

    MailDTO mailQueryModelToMailDTO(MailQueryModel mailQueryModel) {
        return new MailDTO(
                mailQueryModel.id(),
                mailQueryModel.emailFrom(),
                mailQueryModel.emailTo(),
                mailQueryModel.subject(),
                mailQueryModel.createdAt(),
                mailQueryModel.status()
        );
    }
}
