package com.tpokora.mailservice.email.service;

import com.tpokora.mailservice.email.model.EmailStatusEntity;

import java.util.List;

/**
 * Created by pokor on 24.12.2016.
 */
public interface EmailStatusService {
    public List<EmailStatusEntity> getAllEmailStatuses();
}
