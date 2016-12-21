package com.tpokora.mailservice.email;

import com.tpokora.mailservice.email.model.SendMailForm;
import org.thymeleaf.context.Context;

/**
 * Created by pokor on 18.12.2016.
 */
public class Email {

    protected SendMailForm sendMailForm;
    protected Context context;

    private String to;
    private String subject;
    private String templateName;

    public Email(SendMailForm sendMailForm) {
        this.sendMailForm = sendMailForm;
        processSendMailForm();
    }

    private void processSendMailForm() {
        this.to = sendMailForm.getTo();

        switch (sendMailForm.getType().toUpperCase()) {
            case EmailConst.RESET_PASSWORD:
                this.subject = EmailConst.RESET_PASSWORD_MAIL_TOPIC;
                this.templateName = EmailTemplatesConst.RESET_PASSWORD_EMAIL;
                break;
            case EmailConst.REGISTRATION_MAIL_TOPIC:
                this.subject = EmailConst.REGISTRATION_MAIL_TOPIC;
                this.templateName = EmailTemplatesConst.REGISTRATION_EMAIL;
                break;
            default:
                this.subject = "Email topic";
                this.templateName = "";
                break;
        }

        if (sendMailForm.getContent() != null || !sendMailForm.getContent().isEmpty()) {
            context = new Context();
            for (String key : sendMailForm.getContent().keySet()) {
                context.setVariable(key, sendMailForm.getContent().get(key));
            }
            context.setVariable("topic", this.subject);
        }

    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getTemplateName() {
        return templateName;
    }

    public Context getContext() {
        return context;
    }



}
