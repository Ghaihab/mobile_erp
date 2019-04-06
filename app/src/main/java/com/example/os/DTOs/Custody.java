package com.example.os.DTOs;

import com.google.gson.annotations.SerializedName;

public class Custody {
    @SerializedName("id")
    private int Id;
    @SerializedName("name")
    private String name;
    @SerializedName("rate")
    private String rate;

    public Custody(String name, String rate) {
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public String getRate() {
        return rate;
    }

    public int getId(){
        return Id;
    }
}
