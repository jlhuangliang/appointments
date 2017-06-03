package com.mybahmni.appointments.appointment.apis;

import com.mybahmni.appointments.appointment.model.DoctorResource;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@FeignClient("doctor-webservice")
public interface DoctorsService {

    @HystrixCommand(fallbackMethod = "getFallbackCommentsForTask", commandProperties = {
        @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"), @HystrixProperty(name =
        "circuitBreaker.requestVolumeThreshold", value = "10"), @HystrixProperty(name = "circuitBreaker" +
		".sleepWindowInMilliseconds", value = "1000")})
    @RequestMapping("/doctors/{doctorId}")
    DoctorResource getDoctorForAppointment(@PathVariable("doctorId") String doctorId);

    static DoctorResource getFallbackCommentsForTask(String taskId) {

        return new DoctorResource("default", "default doctor", new Date());
    }
}