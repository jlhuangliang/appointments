package com.mybahmni.appointments.appointment.apis;

import com.mybahmni.appointments.appointment.model.PatientResource;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class PatientService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackPatientForAppointment", commandProperties = {
        @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"),
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "1000")})
    public PatientResource getPatientForAppointment(String doctorId) {
        String url = String.format("http://appointment-webservice/patients/%s", doctorId);
        return restTemplate.getForObject(url, PatientResource.class);

    }

    @SuppressWarnings("unused")
    private PatientResource getFallbackPatientForAppointment(String taskId) {

        return new PatientResource("default", "default appointment", new Date());
    }
}
