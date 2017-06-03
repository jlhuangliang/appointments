
package com.mybahmni.appointments.patient.dtos;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.Date;

public class PatientDTO {

	private String patientId;

	private String name;

	private Date posted;

	public PatientDTO() {
		super();

	}

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


