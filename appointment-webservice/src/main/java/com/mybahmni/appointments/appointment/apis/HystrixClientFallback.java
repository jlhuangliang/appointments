package com.mybahmni.appointments.appointment.apis;

import com.mybahmni.appointments.appointment.model.DoctorResource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

@Component
public class HystrixClientFallback implements DoctorsService {

    @Override
    public DoctorResource getDoctorForAppointment(@PathVariable("doctorId") String doctorId) {
        return new DoctorResource("default", "default doctor", new Date());
    }
}
