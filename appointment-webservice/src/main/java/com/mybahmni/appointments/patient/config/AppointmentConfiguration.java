/**
 *
 */
package com.mybahmni.appointments.patient.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Resource server configuration defining what endpoints are protected.
 *
 * @author anilallewar
 */
@Configuration
public class AppointmentConfiguration {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
