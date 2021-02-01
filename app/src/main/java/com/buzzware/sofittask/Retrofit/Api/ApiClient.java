package com.buzzware.sofittask.Retrofit.Api;

import com.buzzware.sofittask.Retrofit.PostService.PostModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiClient {
//todo method:1
    @Headers("Accept: application/json")
    @GET("/posts")
    Call<String> postData();
    //todo method:2
    @Headers("Accept: application/json")
    @GET("Posts")
    Call<ArrayList<PostModel>> postServiceData();
}
