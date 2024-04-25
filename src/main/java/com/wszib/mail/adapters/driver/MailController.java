package com.wszib.mail.adapters.driver;

import com.wszib.mail.hexagon.core.*;
import com.wszib.mail.hexagon.ports.driver.MailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController("/mail")
@RequiredArgsConstructor
public class MailController {

    private MailService mailService;
    private MailMapper mailMapper;

    @PostMapping("/send")
    public ResponseEntity<MailDTO> sendEmail(@RequestBody @Valid MailRequest request) {
        Mail mail = mailService.createEmail(request);
        mailService.sendEmail(mail);
        MailDTO mailDTO = mailMapper.mailToMailDTO(mail);
        return new ResponseEntity<>(mailDTO, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Iterable<MailDTO>> getAll(@PageableDefault(size = 5) Pageable pageable) {
        List<MailDTO> mailDTOList = mailMapper.mailListToMailDTOList(mailService.findAll(pageable));
        return new ResponseEntity<>(mailDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MailDTO> getById(@PathVariable Long id) {
        MailDTO mailDTO = mailMapper.mailToMailDTO(mailService.findById(id));
        return new ResponseEntity<>(mailDTO, HttpStatus.OK);
    }
}