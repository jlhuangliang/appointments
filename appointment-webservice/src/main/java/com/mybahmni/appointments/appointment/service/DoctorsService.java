package com.mybahmni.appointments.appointment.service;

import com.mybahmni.appointments.appointment.model.Doctor;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "doctor-webservice", fallback = HystrixClientFallback.class)
public interface DoctorsService {

//    @HystrixCommand(fallbackMethod = "getFallbackCommentsForTask", commandProperties = {
//        @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"), @HystrixProperty(name =
//        "circuitBreaker.requestVolumeThreshold", value = "10"), @HystrixProperty(name = "circuitBreaker" +
//		".sleepWindowInMilliseconds", value = "1000")})
    @RequestMapping("/doctors/{doctorId}")
    Doctor getDoctorForAppointment(@PathVariable("doctorId") String doctorId);

}

