package com.wszib.mail.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MailNotFoundException extends RuntimeException {

    public MailNotFoundException() { super("Mail not found");}

    public MailNotFoundException(Long id) { super("Mail with given id: " + id +" not found");}

    public MailNotFoundException(String message) {
        super(message);
    }

    public MailNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
