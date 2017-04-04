package com.mybahmni.appointments.patient.apis;

import com.mybahmni.appointments.patient.dtos.PatientDTO;
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

/**
 * REST endpoint for the patients functionality<br>
 * <br>
 * <p>
 * Note that this endpoint is supposed to be consumed by the Task webservice and
 * is not accessible to the general public; i.e. the api-gateway doesn't handle
 * requests for patients-webservice.
 *
 * @author anilallewar
 */
@RestController
@RequestMapping("/patients")
public class PatientController {

    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    private List<PatientDTO> patients = null;

    /**
     * Public constructor to initialize the patients and handle the
     * ParseException
     *
     * @throws ParseException
     */
    public PatientController() throws ParseException {
        this.patients = Arrays.asList(
            new PatientDTO("p001", "Zhang San", formatter.parse("2016-04-23")),
            new PatientDTO("p002", "Li Si", formatter.parse("2016-05-12")),
            new PatientDTO("p003", "Wang Er", formatter.parse("2016-04-27")));
    }

    /**
     * Get patients for specific taskid that is passed in the path.
     *
     * @return
     */
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
