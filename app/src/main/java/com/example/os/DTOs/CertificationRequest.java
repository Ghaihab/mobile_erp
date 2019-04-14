package com.example.os.DTOs;

import com.google.gson.annotations.SerializedName;

public class CertificationRequest {

    @SerializedName("id")
    private int id;

    @SerializedName("course_name")
    private String course_name;

    @SerializedName("training_place")
    private String training_place;

    @SerializedName("expected_hours")
    private Integer expected_hours;

    @SerializedName("from")
    private String from;

    @SerializedName("to")
    private String to;

    @SerializedName("status")
    private String status;

    public CertificationRequest(int id, String course_name, String training_place, Integer expected_hours, String from, String to, String status) {
        this.id = id;
        this.course_name = course_name;
        this.training_place = training_place;
        this.expected_hours = expected_hours;
        this.from = from;
        this.to = to;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getTraining_place() {
        return training_place;
    }

    public Integer getExpected_hours() {
        return expected_hours;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getStatus() {
        return status;
    }
}
