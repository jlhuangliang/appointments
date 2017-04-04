/**
 *
 */
package com.mybahmni.appointments.patient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Resource server configuration defining what endpoints are protected.
 *
 * @author anilallewar
 */
@Configuration
public class TaskConfiguration {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
