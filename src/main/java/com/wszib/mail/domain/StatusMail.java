package com.wszib.mail.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Getter
@RequiredArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class StatusMail {

    private final String value;

    public static final StatusMail SENT = new StatusMail("SENT");
    public static final StatusMail ERROR = new StatusMail("ERROR");
    public static final StatusMail PENDING = new StatusMail("PENDING");

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        StatusMail statusMail = (StatusMail) obj;
        return value.equals(statusMail.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}