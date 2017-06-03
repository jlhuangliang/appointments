package com.mybahmni.appointments.appointment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mybahmni.appointments.appointment.common.CustomDateToStringSerializer;

import java.util.Date;

public class Doctor {

    public static final String JP_DOCTORID = "doctorId";
    public static final String JP_NAME = "name";
    public static final String JP_POSTED = "posted";

    private String doctorId;

    private String name;

    private Date posted;

    public Doctor() {
        super();

    }

    public Doctor(String doctorId, String comment, Date posted) {
        super();
        this.doctorId = doctorId;
        this.name = comment;
        this.posted = posted;
    }

    @JsonProperty(JP_DOCTORID)
    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
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
        result = prime * result + ((doctorId == null) ? 0 : doctorId.hashCode());
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
        Doctor other = (Doctor) obj;
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
        if (doctorId == null) {
            if (other.doctorId != null)
                return false;
        } else if (!doctorId.equals(other.doctorId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Doctor [doctorId=" + doctorId + ", name=" + name + ", posted=" + posted + "]";
    }

}

