package com.example.memegenerator.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MemeModel {
    @SerializedName("url")
    @Expose

    private String ImageUrl;

    public MemeModel(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}
