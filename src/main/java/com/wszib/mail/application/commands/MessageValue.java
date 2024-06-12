package com.wszib.mail.application.commands;

import lombok.Getter;

@Getter
public class MessageValue {
    private String title;
    private String token;

    public MessageValue(String token) {
        this.token = token;
    }
}
