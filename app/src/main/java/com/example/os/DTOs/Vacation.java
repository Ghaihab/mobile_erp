package com.example.os.DTOs;

import com.google.gson.annotations.SerializedName;

public class Vacation {

    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("type")
    private String type;
    @SerializedName("days")
    private Integer days;

    public Vacation(Integer id, String name, String type, Integer days) {

        this.id = id;
        this.name = name;
        this.type = type;
        this.days = days;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Integer getDays() {
        return days;
    }
}
