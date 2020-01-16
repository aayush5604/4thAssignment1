package com.example.a4thassignment.api;

import com.example.a4thassignment.model.User;
import com.example.a4thassignment.serverresponse.SignUpResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserApi {
    @POST("signup")
    Call<SignUpResponse> registerUser(@Body User users);

    @FormUrlEncoded
    @POST("login")
    Call<SignUpResponse> checkUser(@Field("email") String number,@Field("password") String password);
}
