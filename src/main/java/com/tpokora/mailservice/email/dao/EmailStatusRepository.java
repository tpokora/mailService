package com.tpokora.mailservice.email.dao;

import com.tpokora.mailservice.email.model.EmailStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pokor on 24.12.2016.
 */
@Repository
public interface EmailStatusRepository extends JpaRepository<EmailStatusEntity, Integer>{
}
