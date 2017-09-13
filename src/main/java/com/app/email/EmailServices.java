/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.email;

import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 *
 * @author DESARROLLO
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableJms
@EnableAsync
public class EmailServices {
    private static final Logger LOG = Logger.getLogger(EmailServices.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(EmailServices.class, args);
        LOG.info("INICIO -- > EmailServices");
    }
}
