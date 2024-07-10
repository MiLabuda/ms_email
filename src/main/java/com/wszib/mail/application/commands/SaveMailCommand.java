package com.wszib.mail.application.commands;

import java.time.Instant;

class SaveMailCommand {
    private String id;
    private String emailFrom;
    private String emailTo;
    private String subject;
    private String baseUrl;
    private Instant sendDateEmail;
    private String mailType;
    private String status;
}
