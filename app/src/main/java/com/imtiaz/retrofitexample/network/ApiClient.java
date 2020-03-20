package com.imtiaz.retrofitexample.network;

import com.imtiaz.retrofitexample.helper.AllUrl;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if (retrofit == null){
           retrofit = new Retrofit.Builder().baseUrl(AllUrl.API_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
