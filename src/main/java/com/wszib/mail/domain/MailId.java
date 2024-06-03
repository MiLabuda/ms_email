package com.wszib.mail.domain;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

@EqualsAndHashCode
@ToString
final class MailId {
    private final String id;

    public MailId(@NonNull Object id) {
        var idValue = id.toString().strip();
        if (idValue.isBlank()) {
            throw new IllegalArgumentException("ID cannot be empty!");
        }
        this.id = idValue;
    }

    public String value() {
        return id;
    }

}
