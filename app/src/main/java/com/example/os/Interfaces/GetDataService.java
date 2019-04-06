package com.example.os.Interfaces;

import com.example.os.DTOs.Custody;
import com.example.os.DTOs.CustodyRequest;
import com.example.os.DTOs.Login;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface GetDataService {

    @POST("login")
    @FormUrlEncoded
    Call<Login> login(@Field("email") String email, @Field("password") String password);

    @GET("lookup/custodies")
    Call<List<Custody>> getCustodyLookup();

    @POST("custody/requests/create")
    @FormUrlEncoded
    Call <ResponseBody> createCustodyRequest(@Field("custody_id") int custody_id, @Header("Authorization") String authHeader);

    @GET("custody/requests")
    Call <List<CustodyRequest>> getCustodyRequests();

    @GET("custodies")
    Call <List<Custody>> getCustodies(@Header("Authorization") String authHeader);



}
