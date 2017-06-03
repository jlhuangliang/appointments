package com.mybahmni.appointments.appointment.service;

import com.mybahmni.appointments.appointment.model.Doctor;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "doctor-webservice", fallback = HystrixClientFallback.class)
public interface DoctorsService {

    @RequestMapping("/doctors/{doctorId}")
    Doctor getDoctorForAppointment(@PathVariable("doctorId") String doctorId);

}

