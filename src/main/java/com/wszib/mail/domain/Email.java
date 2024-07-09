package com.wszib.mail.domain;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

import java.util.regex.Pattern;

@EqualsAndHashCode
@ToString
public final class Email {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private final String email;

    public Email(@NonNull String email) {
        var emailValue = email.strip();
        if (emailValue.isBlank()) {
            throw new IllegalArgumentException("Email cannot be empty!");
        }
        if (!EMAIL_PATTERN.matcher(emailValue).matches()) {
            throw new IllegalArgumentException("Invalid email format!");
        }
        this.email = emailValue;
    }

    public String value() {
        return email;
    }
}
