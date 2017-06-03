package com.mybahmni.appointments.appointment.service;

import com.mybahmni.appointments.appointment.model.Patient;
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
    public Patient getPatientForAppointment(String doctorId) {
        String url = String.format("http://patient-webservice/patients/%s", doctorId);
        return restTemplate.getForObject(url, Patient.class);

    }

    @SuppressWarnings("unused")
    private Patient getFallbackPatientForAppointment(String taskId) {

        return new Patient("default", "default appointment", new Date());
    }
}
