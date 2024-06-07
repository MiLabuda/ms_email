package com.wszib.mail.domain;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class Text {

    private final String value;

    public Text(@NonNull String value) {
        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException("Text cannot be blank");
        }
        this.value = value;
    }
}