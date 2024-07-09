package com.wszib.mail.application.commands;

import java.time.ZonedDateTime;

class SaveMailCommand {
    private String id;
    private String emailFrom;
    private String emailTo;
    private String subject;
    private String baseUrl;
    private ZonedDateTime sendDateEmail;
    private String mailType;
    private String status;
}
