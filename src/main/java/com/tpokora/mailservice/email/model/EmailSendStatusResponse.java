package com.tpokora.mailservice.email.model;

/**
 * Created by pokor on 17.12.2016.
 */
public class EmailSendStatusResponse {

    private String to;
    private String status;

    public EmailSendStatusResponse(String to, String status) {
        this.to = to;
        this.status = status;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
