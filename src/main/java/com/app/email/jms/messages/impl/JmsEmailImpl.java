package com.app.email.jms.messages.impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.app.email.interfaces.email.facade.EmailServiceFacade;
import com.app.email.interfaces.email.facade.dto.PasswordDTO;
import com.app.email.jms.messages.JmsEmailService;
import com.app.email.utils.ObjectMapperUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.logging.Level;
import javax.jms.Session;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.mail.MailException;

/**
 *
 * @author DESARROLLO 13
 */
@Component
public class JmsEmailImpl implements JmsEmailService {

    public final static Logger LOG = LoggerFactory.getLogger(JmsEmailImpl.class);

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    EmailServiceFacade emailServiceFacade;

    ObjectMapper mapper = ObjectMapperUtil.getInstanceObjectMapper();

    @JmsListener(destination = "${messages.queue.jmsresetpassword}")
    @Override
    public void sendEmailResetPassword(String email) {
        try {
            PasswordDTO passwordDTO = mapper.convertValue(mapper.readTree(email), PasswordDTO.class);
            emailServiceFacade.sendEmailResetPassword(passwordDTO);
        } catch (IOException | IllegalArgumentException e) {
            LOG.error("Error : " + e);
        } catch (MailException | InterruptedException ex) {
            java.util.logging.Logger.getLogger(JmsEmailImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @JmsListener(destination = "${messages.queue.jmsregistry}")
    @Override
    public void sendEmailRegistry(String email) {
        try {
            PasswordDTO passwordDTO = mapper.convertValue(mapper.readTree(email), PasswordDTO.class);
            emailServiceFacade.sendEmailRegistry(passwordDTO);
        } catch (IOException | IllegalArgumentException e) {
            LOG.error("Error : " + e);
        } catch (MailException | InterruptedException ex) {
            java.util.logging.Logger.getLogger(JmsEmailImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
