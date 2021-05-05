package com.example.memegenerator.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//create retrofit instance
public class RetrofitInstance {
    private static Retrofit retrofit;
    private static final String BASEURL = "https://meme-api.herokuapp.com/";

    public static Retrofit getRetrofit() {
        //checking if the instance is created before or not
        if (retrofit == null) {
            retrofit =new Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }


}
