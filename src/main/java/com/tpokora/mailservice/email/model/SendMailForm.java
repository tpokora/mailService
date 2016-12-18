package com.tpokora.mailservice.email.model;

import java.util.HashMap;

/**
 * Created by pokor on 17.12.2016.
 */
public class SendMailForm {

    private String to;
    private String type;
    private HashMap<String, Object> content;

    public SendMailForm() {}

    public SendMailForm(String to, String type, HashMap<String, Object> content) {
        this.to = to;
        this.type = type;
        this.content = content;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HashMap<String, Object> getContent() {
        return content;
    }

    public void setContent(HashMap<String, Object> content) {
        this.content = content;
    }
}
