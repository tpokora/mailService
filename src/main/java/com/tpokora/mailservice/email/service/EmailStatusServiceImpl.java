package com.tpokora.mailservice.email.service;

import com.tpokora.mailservice.email.dao.EmailStatusRepository;
import com.tpokora.mailservice.email.model.EmailStatusEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by pokor on 24.12.2016.
 */
@Service("emailStatusService")
public class EmailStatusServiceImpl implements EmailStatusService {

    @Resource
    private EmailStatusRepository emailStatusRepo;

    @Override
    public List<EmailStatusEntity> getAllEmailStatuses() {
        return emailStatusRepo.findAll();
    }
}
