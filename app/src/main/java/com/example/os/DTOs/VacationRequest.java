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

    public VacationRequest(Integer id, String status, Vacation vacation) {
        this.id = id;
        this.status = status;
        this.vacation = vacation;
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
}
