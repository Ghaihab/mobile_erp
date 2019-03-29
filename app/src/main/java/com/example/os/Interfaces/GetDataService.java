package com.example.os.Interfaces;

import com.example.os.DTOs.Login;
import com.example.os.DTOs.RetroPhoto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GetDataService {

    @GET("/photos")
    Call<List<RetroPhoto>> getAllPhotos();

    @POST("/api/login")
    @FormUrlEncoded
    Call<Login> login(@Field("email") String email, @Field("password") String password);
}
