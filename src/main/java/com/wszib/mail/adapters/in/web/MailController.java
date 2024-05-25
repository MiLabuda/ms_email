package com.wszib.mail.adapters.in.web;

import com.wszib.mail.application.ports.in.GetMailUseQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/mail")
@RequiredArgsConstructor
public class MailController {

    private final GetMailUseQuery getMailUseQuery;
    private final MailWebMapper mailWebMapper;

    @GetMapping()
    public ResponseEntity<Iterable<MailDTO>> getAll(@PageableDefault(size = 5) Pageable pageable) {
        List<MailDTO> mailDTOList = mailWebMapper.mailListToMailDTOList(getMailUseQuery.findAll(pageable));
        return ResponseEntity.ok(mailDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MailDTO> getById(@PathVariable Long id) {
        MailDTO mailDTO = mailWebMapper.mailToMailDTO(getMailUseQuery.findById(id));
        return ResponseEntity.ok(mailDTO);
    }
}
