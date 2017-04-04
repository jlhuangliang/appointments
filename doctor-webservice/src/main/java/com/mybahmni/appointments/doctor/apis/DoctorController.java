package com.mybahmni.appointments.doctor.apis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.mybahmni.appointments.doctor.dtos.DoctorDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST endpoint for the doctors functionality<br>
 * <br>
 * 
 * Note that this endpoint is supposed to be consumed by the Task webservice and
 * is not accessible to the general public; i.e. the api-gateway doesn't handle
 * requests for doctors-webservice.
 * 
 * @author anilallewar
 *
 */
@RestController
@RequestMapping("/doctors")
public class DoctorController {

	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	private List<DoctorDTO> doctors = null;

	/**
	 * Public constructor to initialize the doctors and handle the
	 * ParseException
	 * 
	 * @throws ParseException
	 */
	public DoctorController() throws ParseException {
		this.doctors = Arrays.asList(
				new DoctorDTO("d001", "Li Shizhen", formatter.parse("2015-04-23")),
				new DoctorDTO("d002", "Hua Tuo", formatter.parse("2015-05-12")),
				new DoctorDTO("d003", "Zhang Zhongjing", formatter.parse("2015-04-27")));
	}

	/**
	 * Get doctors for specific taskid that is passed in the path.
	 * 
	 * @return
	 */
	@GetMapping
	public List<DoctorDTO> getCommentsByTaskId() {

		return doctors;
	}

	@RequestMapping(value = "/{doctorId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public DoctorDTO getDoctorByDoctorId(@PathVariable("doctorId") final String doctorId) {
		Optional<DoctorDTO> doctor = doctors.stream().filter(c -> Objects.equals(c.getDoctorId(), doctorId)).findAny();

		return doctor.isPresent() ? doctor.get() : null;
	}
}
