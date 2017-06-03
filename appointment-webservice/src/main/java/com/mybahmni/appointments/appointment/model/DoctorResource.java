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
public class DoctorResource {

    public static final String JP_DOCTORID = "doctorId";
    public static final String JP_NAME = "name";
    public static final String JP_POSTED = "posted";

    /**
     * The task id.
     */
    private String doctorId;

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
    public DoctorResource() {
        super();

    }

    /**
     * Instantiates a new name resource
     *
     * @param doctorId
     * @param comment
     * @param posted
     */
    public DoctorResource(String doctorId, String comment, Date posted) {
        super();
        this.doctorId = doctorId;
        this.name = comment;
        this.posted = posted;
    }

    /**
     * @return the doctorId
     */
    @JsonProperty(JP_DOCTORID)
    public String getDoctorId() {
        return doctorId;
    }

    /**
     * @param doctorId the doctorId to set
     */
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
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
        result = prime * result + ((doctorId == null) ? 0 : doctorId.hashCode());
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
        DoctorResource other = (DoctorResource) obj;
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

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "DoctorResource [doctorId=" + doctorId + ", name=" + name + ", posted=" + posted + "]";
    }

}

