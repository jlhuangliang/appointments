package com.mybahmni.appointments.appointment.service;

import com.mybahmni.appointments.appointment.model.Doctor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

@Component
public class HystrixClientFallback implements DoctorsService {

    @Override
    public Doctor getDoctorForAppointment(@PathVariable("doctorId") String doctorId) {
        return new Doctor("default", "default doctor", new Date());
    }
}
