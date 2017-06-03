package com.mybahmni.appointments.doctor.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.Date;

public class Doctor {

	private String doctorId;

	private String name;

	private Date posted;

	public Doctor() {
		super();

	}

	public Doctor(String doctorId, String name, Date posted) {
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

	@JsonSerialize(using = CustomDateToLongSerializer.class)
	public Date getPosted() {
		return posted;
	}

	public void setPosted(Date posted) {
		this.posted = posted;
	}

}

class CustomDateToLongSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider)
		throws IOException, JsonProcessingException {
		jgen.writeNumber(value.getTime());
	}
}


