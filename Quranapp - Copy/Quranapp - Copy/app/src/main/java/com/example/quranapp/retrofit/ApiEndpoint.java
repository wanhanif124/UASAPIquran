package com.example.quranapp.retrofit;

import com.example.quranapp.model.Chapters;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpoint {
    @GET("chapters?language=id")
    Call<Chapters> getSurah();

}
