package com.example.os.Interfaces;

import com.example.os.DTOs.CertificationRequest;
import com.example.os.DTOs.Custody;
import com.example.os.DTOs.CustodyRequest;
import com.example.os.DTOs.Login;
import com.example.os.DTOs.Vacation;
import com.example.os.DTOs.VacationRequest;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

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

    @GET("custody/manager/requests")
    Call <List<CustodyRequest>> getCustodyRequestsUnderManager();

    @GET("custody/hr/requests")
    Call <List<CustodyRequest>> getCustodyRequestsUnderHr();

    @POST("custody/manager/request/accept/{id}")
    Call<ResponseBody> managerAcceptCustodyRequest(@Path("id") Integer id);

    @POST("custody/hr/request/accept/{id}")
    Call<ResponseBody> hrAcceptCustodyRequest(@Path("id") Integer id);

    @POST("custody/request/reject/{id}")
    Call<ResponseBody> rejectCustodyRequest(@Path("id") Integer id);

    @GET("custodies")
    Call <List<Custody>> getCustodies(@Header("Authorization") String authHeader);

    @GET("lookup/vacations")
    Call<List<Vacation>> getVacationLookup();

    @POST("vacation/requests/create")
    @FormUrlEncoded
    Call <ResponseBody> createVacationRequest(@Field("vacation_id") int vacation_id, @Header("Authorization") String authHeader);

    @GET("vacation/requests")
    Call <List<VacationRequest>> getVacationRequests();

    @GET("vacation/manager/requests")
    Call <List<VacationRequest>> getVacationRequestsUnderManager();

    @GET("vacation/hr/requests")
    Call <List<VacationRequest>> getVacationRequestsUnderHr();

    @POST("vacation/manager/request/accept/{id}")
    Call<ResponseBody> managerAcceptVacationRequest(@Path("id") Integer id);

    @POST("vacation/hr/request/accept/{id}")
    Call<ResponseBody> hrAcceptVacationRequest(@Path("id") Integer id);

    @POST("vacation/request/reject/{id}")
    Call<ResponseBody> rejectVacationRequest(@Path("id") Integer id);

    @GET("vacations")
    Call <List<Vacation>> getVacations(@Header("Authorization") String authHeader);

    @POST("upload/requests/create")
    Call <ResponseBody> createCertificationRequest(
            @Header("Authorization") String authHeader,
            String course_name,
            String training_palce,
            String expected_hours,
            String from,
            String to
    );

    @GET("upload/requests")
    Call <List<CertificationRequest>> getCertificationRequests();

    @GET("upload/hr/requests")
    Call <List<CertificationRequest>> getCertificationRequestsUnderHr();

    @GET("upload/manager/requests")
    Call <List<CertificationRequest>> getCertificationRequestsUnderManager();

    @POST("upload/manager/request/accept/{id}")
    Call <ResponseBody> managerAcceptCertificationRequest(@Path("id") Integer id);

    @POST("upload/hr/request/accept/{id}")
    Call <ResponseBody> hrAcceptCertificationRequest(@Path("id") Integer id);

    @POST("upload/request/reject/{id}")
    Call <ResponseBody> rejectCertificationRequest(@Path("id") Integer id);

    @POST("change/password")
    @FormUrlEncoded
    Call <ResponseBody> changePassword(@Field("password") String password, @Header("Authorization") String authHead);



}
