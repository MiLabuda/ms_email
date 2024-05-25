package com.wszib.mail.application.core;

import com.wszib.mail.adapters.out.SaveMailAdapter;
import com.wszib.mail.domain.EMailType;
import com.wszib.mail.domain.EStatusMail;
import com.wszib.mail.domain.Mail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class SendMailTest {

    @Mock
    private JavaMailSender javaMailSender;

    @Mock
    private TemplateServiceImpl templateServiceImpl;

    @Mock
    private SaveMailAdapter saveMailAdapter;

    @InjectMocks
    private SendMailService mailService;

    private Mail mail;

    @BeforeEach
    void setUp() {
        mail = new Mail();
        mail.setType(EMailType.RESET_PASSWORD);
        mail.setBaseUrl("http://example.com");
        mail.setText("sampleToken");
        mail.setEmailTo("user@example.com");
    }

    @Test
    void testSendEmail_success() {
        SimpleMailMessage message = new SimpleMailMessage();
        when(templateServiceImpl.constructEmail(any(Mail.class))).thenReturn(message);

        mailService.sendEmail(mail);

        verify(javaMailSender, times(1)).send(message);
        assertEquals(EStatusMail.SENT, mail.getStatus());
        verify(saveMailAdapter, times(1)).save(mail);
    }

    @Test
    void testSendEmail_failure() {
        SimpleMailMessage message = new SimpleMailMessage();
        when(templateServiceImpl.constructEmail(any(Mail.class))).thenReturn(message);
        doThrow(new RuntimeException()).when(javaMailSender).send(any(SimpleMailMessage.class));

        mailService.sendEmail(mail);

        assertEquals(EStatusMail.ERROR, mail.getStatus());
        verify(saveMailAdapter, times(1)).save(mail);
    }
}
