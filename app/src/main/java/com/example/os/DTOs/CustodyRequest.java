package com.example.os.DTOs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustodyRequest {
    @SerializedName("id")
    private int id;

    @SerializedName("status")
    private String status;

    @SerializedName("custody")
    @Expose
    private Custody custody;

    public CustodyRequest(Integer id, String status, Custody custody) {
        this.id = id;
        this.status = status;
        this.custody = custody;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public Custody getCustody() {
        return custody;
    }
}
