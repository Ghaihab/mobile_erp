package com.example.os.DTOs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VacationRequest {

    @SerializedName("id")
    private Integer id;
    @SerializedName("status")
    private String status;
    @SerializedName("vacation")
    @Expose
    private Vacation vacation;

    @SerializedName("number_of_days")
    private String number_of_days;

    public VacationRequest(Integer id, String status, Vacation vacation, String number_of_days) {
        this.id = id;
        this.status = status;
        this.vacation = vacation;
        this.number_of_days = number_of_days;
    }

    public Integer getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public Vacation getVacation() {
        return vacation;
    }

    public String getNumberOfDays(){
        return number_of_days;
    }
}
