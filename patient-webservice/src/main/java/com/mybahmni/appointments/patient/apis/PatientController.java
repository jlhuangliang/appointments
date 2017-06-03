package com.mybahmni.appointments.patient.apis;

import com.mybahmni.appointments.patient.dtos.PatientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
@RefreshScope
public class PatientController {

    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    private List<PatientDTO> patients = null;

    @Autowired
    public PatientController(@Value("${instance.name}") String instanceName) throws ParseException {

        this.patients = Arrays.asList(
            new PatientDTO("p001", "Zhang San" + instanceName, formatter.parse("2016-04-23")),
            new PatientDTO("p002", "Li Si" + instanceName, formatter.parse("2016-05-12")),
            new PatientDTO("p003", "Wang Er" + instanceName, formatter.parse("2016-04-27")));
    }

    @GetMapping
    public List<PatientDTO> getPatients() {

        return patients;
    }

    @RequestMapping(value = "/{patientsId}", method = RequestMethod.GET, headers = "Accept=application/json")
    public PatientDTO getDoctorByDoctorId(@PathVariable("patientsId") final String patientsId) {
        Optional<PatientDTO> doctor = patients.stream().filter(c -> Objects.equals(c.getPatientId(), patientsId)).findAny();

        return doctor.isPresent() ? doctor.get() : null;
    }
}
