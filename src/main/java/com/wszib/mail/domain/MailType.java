package com.wszib.mail.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Getter
@RequiredArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class MailType {

    private final String value;

    public static final MailType RESET_PASSWORD = new MailType("RESET_PASSWORD");
    public static final MailType REGISTRATION_CONFIRMATION = new MailType("REGISTRATION_CONFIRMATION");
    public static final MailType CONTACT_US = new MailType("CONTACT_US");

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MailType mailType = (MailType) obj;
        return value.equals(mailType.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}