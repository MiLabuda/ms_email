package com.wszib.mail.adapters.in.api;

import com.wszib.mail.application.ports.in.GetMailUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
@RequiredArgsConstructor
class MailController {

    private final GetMailUseCase getMailUseCase;
    private final MailWebMapper mailWebMapper;

    @GetMapping()
    Iterable<MailDTO> getAll(@PageableDefault(size = 5) Pageable pageable) {
        Page<MailDTO> mailDTOList = mailWebMapper.mailPageToMailDTOPage(getMailUseCase.findAll(pageable));
        return mailDTOList.getContent();
    }

    @GetMapping("/{id}")
    MailDTO getById(@PathVariable Long id) {
        MailDTO mailDTO = mailWebMapper.mailQueryModelToMailDTO(getMailUseCase.findById(id));
        return mailDTO.of(getMailUseCase.findById(id));
    }
}
