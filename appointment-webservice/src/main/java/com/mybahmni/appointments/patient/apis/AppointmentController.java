package com.mybahmni.appointments.patient.apis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import com.mybahmni.appointments.patient.dtos.AppointmentDTO;
import com.mybahmni.appointments.patient.model.DoctorResource;
import com.mybahmni.appointments.patient.model.PatientResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST endpoint for the task functionality
 * 
 */
@RestController
@RequestMapping("/")
public class AppointmentController {

	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");

	@Autowired
	private DoctorsService doctorsService;


	@Autowired
	private PatientService patientService;

	private List<AppointmentDTO> appointments = Arrays.asList(
		new AppointmentDTO("a001", "d001", "p001",
			formatter.parse("2017-05-01 14:00"), formatter.parse("2017-05-01 15:00")),
		new AppointmentDTO("a002", "d001", "p002",
			formatter.parse("2017-05-01 16:00"), formatter.parse("2017-05-01 17:00")));

	public AppointmentController() throws ParseException {

	}

	/**
	 * Get all appointments
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
	public List<AppointmentDTO> getAppointments() {
		return appointments;
	}

	/**
	 * Get appointments for specific taskid
	 * 
	 * @param appointmentId
	 * @return
	 */
	@RequestMapping(value = "{appointmentId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public AppointmentDTO getTaskByTaskId(@PathVariable("appointmentId") String appointmentId) {
		AppointmentDTO appointmentToReturn = null;
		for (AppointmentDTO currentTask : appointments) {
			if (currentTask.getAppointmentId().equalsIgnoreCase(appointmentId)) {
				appointmentToReturn = currentTask;
				break;
			}
		}

		if (appointmentToReturn != null) {
			DoctorResource doctor = this.doctorsService.getDoctorForAppointment(appointmentToReturn.getDoctorId());
			appointmentToReturn.setDoctor(doctor);
			PatientResource patient = patientService.getPatientForAppointment(appointmentToReturn.getPatientId());
			appointmentToReturn.setPatient(patient);
		}

		return appointmentToReturn;
	}

}
