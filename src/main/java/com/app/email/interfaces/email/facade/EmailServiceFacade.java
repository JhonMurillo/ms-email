/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.email.interfaces.email.facade;

import com.app.email.interfaces.email.facade.dto.PasswordDTO;
import org.springframework.mail.MailException;

/**
 *
 * @author DESARROLLO 13
 */
public interface EmailServiceFacade {

    public void sendEmailResetPassword(PasswordDTO passwordDTO) throws MailException, InterruptedException;
    
    public void sendEmailRegistry(PasswordDTO passwordDTO) throws MailException, InterruptedException;
}
