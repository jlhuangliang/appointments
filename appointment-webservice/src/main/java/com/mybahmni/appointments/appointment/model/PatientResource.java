package com.mybahmni.appointments.appointment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mybahmni.appointments.appointment.common.CustomDateToStringSerializer;

import java.util.Date;

/**
 * Represents comments on Task.
 *
 * @author anilallewar
 */
public class PatientResource {

    public static final String JP_DOCTORID = "patientId";
    public static final String JP_NAME = "name";
    public static final String JP_POSTED = "posted";

    /**
     * The task id.
     */
    private String patientId;

    /**
     * The last name.
     */
    private String name;

    /**
     * The completed.
     */
    private Date posted;

    /**
     * Instantiates a new name resource
     */
    public PatientResource() {
        super();

    }

    /**
     * Instantiates a new name resource
     *
     * @param patientId
     * @param comment
     * @param posted
     */
    public PatientResource(String patientId, String comment, Date posted) {
        super();
        this.patientId = patientId;
        this.name = comment;
        this.posted = posted;
    }

    /**
     * @return the patientId
     */
    @JsonProperty(JP_DOCTORID)
    public String getPatientId() {
        return patientId;
    }

    /**
     * @param patientId the patientId to set
     */
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    /**
     * @return the name
     */
    @JsonProperty(JP_NAME)
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the posted
     */
    @JsonProperty(JP_POSTED)
    @JsonSerialize(using = CustomDateToStringSerializer.class)
    public Date getPosted() {
        return posted;
    }

    /**
     * @param posted the posted to set
     */
    public void setPosted(Date posted) {
        this.posted = posted;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((posted == null) ? 0 : posted.hashCode());
        result = prime * result + ((patientId == null) ? 0 : patientId.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PatientResource other = (PatientResource) obj;
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

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "DoctorResource [patientId=" + patientId + ", name=" + name + ", posted=" + posted + "]";
    }

}

