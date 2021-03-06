/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.email;

import java.util.logging.Logger;
import javax.servlet.Filter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 *
 * @author DESARROLLO
 */
@SpringBootApplication
@EnableJms
@EnableAsync
public class EmailServices {
    private static final Logger LOG = Logger.getLogger(EmailServices.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(EmailServices.class, args);
        LOG.info("INICIO -- > EmailServices");
    }
    
    @Bean
    public Filter shallowEtagHeaderFilter() {
        return new SimpleCORSFilter();
    }
}
