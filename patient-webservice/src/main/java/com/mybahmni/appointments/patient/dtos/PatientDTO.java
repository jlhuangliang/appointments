/**
 * 
 */
package com.mybahmni.appointments.patient.dtos;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.Date;

/**
 * Represents comments on Task.
 *
 */
public class PatientDTO {

	/** The task id. */
	private String patientId;

	/** The name. */
	private String name;

	/** The completed. */
	private Date posted;

	/**
	 * Instantiates a new task dto.
	 */
	public PatientDTO() {
		super();

	}

	/**
	 * Instantiates a new task dto.
	 *
	 * @param patientId
	 *            the task id
	 */
	public PatientDTO(String patientId, String name, Date posted) {
		super();
		this.patientId = patientId;
		this.name = name;
		this.posted = posted;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the posted
	 */
	@JsonSerialize(using = CustomDateToLongSerializer.class)
	public Date getPosted() {
		return posted;
	}

	/**
	 * @param posted
	 *            the posted to set
	 */
	public void setPosted(Date posted) {
		this.posted = posted;
	}

}

/**
 * Custom date serializer that converts the date to long before sending it out
 *
 * @author anilallewar
 *
 */
class CustomDateToLongSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider)
		throws IOException, JsonProcessingException {
		jgen.writeNumber(value.getTime());
	}
}


