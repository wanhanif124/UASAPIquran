package com.example.uaspemogramanbergerak.retrofit;

import com.example.uaspemogramanbergerak.surahmodel.Chapters;

import retrofit2.Call;
import retrofit2.http.GET;


public interface APIendpoint {
    @GET("chapters?language=id")
    Call<Chapters> getSurah();
}
