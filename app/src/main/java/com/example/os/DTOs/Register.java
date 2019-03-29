package com.example.os.DTOs;

import com.google.gson.annotations.SerializedName;

public class Register {


    @SerializedName("access_token")
    private String access_token;
    @SerializedName("token_type")
    private String token_type;
    @SerializedName("expires_in")
    private Integer expires_in;

    public Register(String access_token, String token_type, Integer expires_in) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.expires_in = expires_in;
    }

    public String getAccessToken()
    {
        return this.access_token;
    }

}
