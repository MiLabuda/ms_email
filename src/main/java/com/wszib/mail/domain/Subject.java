package com.wszib.mail.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class Subject {

    private final String value;

    public Subject(@NonNull String value) {
        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject cannot be blank");
        }
        if (value.length() > 200) {
            throw new IllegalArgumentException("Subject cannot be longer than 200 characters");
        }
        this.value = value;
    }
}