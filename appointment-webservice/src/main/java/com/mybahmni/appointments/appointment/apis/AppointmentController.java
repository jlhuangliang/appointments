package com.mybahmni.appointments.appointment.apis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import com.mybahmni.appointments.appointment.model.Appointment;
import com.mybahmni.appointments.appointment.model.Doctor;
import com.mybahmni.appointments.appointment.model.Patient;
import com.mybahmni.appointments.appointment.service.DoctorsService;
import com.mybahmni.appointments.appointment.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AppointmentController {

	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");

	@Autowired
	private DoctorsService doctorsService;


	@Autowired
	private PatientService patientService;

	private List<Appointment> appointments = Arrays.asList(
		new Appointment("a001", "d001", "p001",
			formatter.parse("2017-05-01 14:00"), formatter.parse("2017-05-01 15:00")),
		new Appointment("a002", "d001", "p002",
			formatter.parse("2017-05-01 16:00"), formatter.parse("2017-05-01 17:00")));

	public AppointmentController() throws ParseException {

	}

	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Appointment> getAppointments() {
		return appointments;
	}

	@RequestMapping(value = "{appointmentId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Appointment getTaskByTaskId(@PathVariable("appointmentId") String appointmentId) {
		Appointment appointmentToReturn = null;
		for (Appointment currentTask : appointments) {
			if (currentTask.getAppointmentId().equalsIgnoreCase(appointmentId)) {
				appointmentToReturn = currentTask;
				break;
			}
		}

		if (appointmentToReturn != null) {
			Doctor doctor = this.doctorsService.getDoctorForAppointment(appointmentToReturn.getDoctorId());
			appointmentToReturn.setDoctor(doctor);
			Patient patient = patientService.getPatientForAppointment(appointmentToReturn.getPatientId());
			appointmentToReturn.setPatient(patient);
		}

		return appointmentToReturn;
	}


	@RequestMapping(value = "patients/{patientId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Patient getPatientById(@PathVariable("patientId") String patientId) {

		return patientService.getPatientForAppointment(patientId);
	}
}
