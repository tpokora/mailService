package com.tpokora.mailservice.email;

/**
 * Created by pokor on 17.12.2016.
 */
public class EmailStatus {

    public static final String SUCCESS = "SUCCESS";
    public static final String ERROR = "ERROR";

    private String to;
    private String subject;
    private String content;

    private String status;
    private String errorMsg;

    public EmailStatus(String to, String subject, String content) {
        this.to = to;
        this.subject = subject;
        this.content = content;
    }

    public EmailStatus success() {
        this.status = SUCCESS;
        return this;
    }

    public EmailStatus error(String errorMsg) {
        this.status = ERROR;
        this.errorMsg = errorMsg;
        return this;
    }

    public boolean isSuccess() {
        return SUCCESS.equals(this.status);
    }

    public boolean isError() {
        return ERROR.equals(this.status);
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public String getStatus() {
        return status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
