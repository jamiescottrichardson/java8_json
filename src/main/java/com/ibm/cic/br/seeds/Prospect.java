package com.ibm.cic.br.seeds;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;

public class Prospect {

    private String id;
    private String lastName;
    private String firstName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addDate;
    private String lastRecordedGeo;
    private String residentState;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("addDate")
    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    @JsonProperty("lastRecordedGeo")
    public String getLastRecordedGeo() {
        return lastRecordedGeo;
    }

    public void setLastRecordedGeo(String lastRecordedGeo) {
        this.lastRecordedGeo = lastRecordedGeo;
    }

    @JsonProperty("residentState")
    public String getResidentState() {
        return residentState;
    }

    public void setResidentState(String residentState) {
        this.residentState = residentState;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            System.err.println(e.getMessage());
            return "{}";
        }
    }
}
