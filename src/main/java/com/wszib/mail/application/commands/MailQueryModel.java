package com.wszib.mail.application.commands;

public record MailQueryModel(
        String id,
        String emailFrom,
        String emailTo,
        String subject,
        String hostUrl,
        String sendDateEmail,
        String EStatusMail
) {

}
