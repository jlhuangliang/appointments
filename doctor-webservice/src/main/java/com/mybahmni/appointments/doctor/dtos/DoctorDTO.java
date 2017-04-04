/**
 * 
 */
package com.mybahmni.appointments.doctor.dtos;

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
 * @author anilallewar
 */
public class DoctorDTO {

	/** The task id. */
	private String doctorId;

	/** The last name. */
	private String name;

	/** The completed. */
	private Date posted;

	/**
	 * Instantiates a new task dto.
	 */
	public DoctorDTO() {
		super();

	}

	/**
	 * Instantiates a new task dto.
	 *
	 * @param doctorId
	 *            the task id
	 * @param description
	 *            the description
	 */
	public DoctorDTO(String doctorId, String name, Date posted) {
		super();
		this.doctorId = doctorId;
		this.name = name;
		this.posted = posted;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
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


