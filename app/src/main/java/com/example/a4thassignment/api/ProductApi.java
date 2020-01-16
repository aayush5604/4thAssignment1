package com.example.a4thassignment.api;

import android.content.ClipData;

import com.example.a4thassignment.model.Items;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductApi {
    @GET("product/save")
    Call<List<Items>> getProduct();
}
