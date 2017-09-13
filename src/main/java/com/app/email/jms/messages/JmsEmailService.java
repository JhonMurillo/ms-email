/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.email.jms.messages;

/**
 *
 * @author Desarrollo4
 */
public interface JmsEmailService {

    void sendEmailResetPassword(String email);
    
    void sendEmailRegistry(String email);

}
