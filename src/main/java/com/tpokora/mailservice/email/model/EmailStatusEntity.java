package com.tpokora.mailservice.email.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tpokora.mailservice.common.model.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by pokor on 24.12.2016.
 */
@Entity
@Table(name = "EMAIL_STATUS")

public class EmailStatusEntity extends AbstractEntity {

    @Column(name = "mail")
    private String mail;

    @Column(name = "action")
    private String action;

    @Column(name = "status")
    private String status;

    @Column(name = "date")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm")
    private Date date;

    public EmailStatusEntity() {
        super();
    }

    public EmailStatusEntity(Integer id, String mail, String action, String status, Date date) {
        this.mail = mail;
        this.action = action;
        this.status = status;
        this.date = date;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
