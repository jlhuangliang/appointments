/**
 *
 */
package com.mybahmni.appointments.appointment.dtos;

import com.mybahmni.appointments.appointment.model.DoctorResource;
import com.mybahmni.appointments.appointment.model.PatientResource;

import java.util.Date;

/**
 * Represents Todo Task.
 */
public class AppointmentDTO {

    private String appointmentId;
    private String doctorId;
    private String patientId;

    private Date start;
    private Date end;

    private DoctorResource doctor;
    private PatientResource patient;

    /**
     * Instantiates a new task dto.
     */
    public AppointmentDTO() {
        super();

    }

    /**
     * Instantiates a new task dto.
     *
     * @param appointmentId the task id
     * @param doctorId      the doctorId
     */
    public AppointmentDTO(String appointmentId, String doctorId, String patientId, Date start, Date end) {
        super();
        this.appointmentId = appointmentId;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.start = start;
        this.end = end;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public DoctorResource getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorResource doctor) {
        this.doctor = doctor;
    }

    public PatientResource getPatient() {
        return patient;
    }

    public void setPatient(PatientResource patient) {
        this.patient = patient;
    }
}
