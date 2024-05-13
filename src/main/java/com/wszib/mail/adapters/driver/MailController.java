package com.wszib.mail.adapters.driver;

import com.wszib.mail.hexagon.ports.driver.MailService;
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

    private final MailService mailService;
    private final MailMapper mailMapper;

    @GetMapping()
    public ResponseEntity<Iterable<MailDTO>> getAll(@PageableDefault(size = 5) Pageable pageable) {
        List<MailDTO> mailDTOList = mailMapper.mailListToMailDTOList(mailService.findAll(pageable));
        return ResponseEntity.ok(mailDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MailDTO> getById(@PathVariable Long id) {
        MailDTO mailDTO = mailMapper.mailToMailDTO(mailService.findById(id));
        return ResponseEntity.ok(mailDTO);
    }
}
