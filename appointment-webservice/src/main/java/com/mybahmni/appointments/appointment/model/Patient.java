package com.mybahmni.appointments.appointment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mybahmni.appointments.appointment.common.CustomDateToStringSerializer;

import java.util.Date;

public class Patient {

    public static final String JP_DOCTORID = "patientId";
    public static final String JP_NAME = "name";
    public static final String JP_POSTED = "posted";

    private String patientId;

    private String name;

    private Date posted;

    public Patient() {
        super();

    }

    public Patient(String patientId, String comment, Date posted) {
        super();
        this.patientId = patientId;
        this.name = comment;
        this.posted = posted;
    }

    @JsonProperty(JP_DOCTORID)
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    @JsonProperty(JP_NAME)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty(JP_POSTED)
    @JsonSerialize(using = CustomDateToStringSerializer.class)
    public Date getPosted() {
        return posted;
    }

    public void setPosted(Date posted) {
        this.posted = posted;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((posted == null) ? 0 : posted.hashCode());
        result = prime * result + ((patientId == null) ? 0 : patientId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Patient other = (Patient) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (posted == null) {
            if (other.posted != null)
                return false;
        } else if (!posted.equals(other.posted))
            return false;
        if (patientId == null) {
            if (other.patientId != null)
                return false;
        } else if (!patientId.equals(other.patientId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Doctor [patientId=" + patientId + ", name=" + name + ", posted=" + posted + "]";
    }

}

