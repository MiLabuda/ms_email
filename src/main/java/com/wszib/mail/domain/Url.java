package com.wszib.mail.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;
import lombok.Getter;

import java.net.MalformedURLException;
import java.net.URL;

@Getter
public class Url {

    private final String value;

    public Url(@NonNull String value) {
        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException("URL cannot be blank");
        }
        try {
            new URL(value); // checks for a valid URL format
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid URL format", e);
        }
        this.value = value;
    }
}