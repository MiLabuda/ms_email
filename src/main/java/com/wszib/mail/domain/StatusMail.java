package com.wszib.mail.domain;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
@EqualsAndHashCode
@RequiredArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class StatusMail {

    private final String value;

    public static final StatusMail SENT = new StatusMail("SENT");
    public static final StatusMail ERROR = new StatusMail("ERROR");
    public static final StatusMail PENDING = new StatusMail("PENDING");


    public String value() {
        return value;
    }

}