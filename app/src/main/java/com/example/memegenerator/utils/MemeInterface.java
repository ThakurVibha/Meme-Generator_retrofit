package com.example.memegenerator.utils;

import com.example.memegenerator.models.MemeModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MemeInterface {


@GET("gimme")
    Call<MemeModel> getMemes();
}
