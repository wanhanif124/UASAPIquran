package com.example.uaspemogramanbergerak.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIservices {
    private static String BASE_URL = "https://api.quran.com/api/v4/";
    private static Retrofit retrofit;

    public static APIendpoint endpoint () {
         retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(APIendpoint.class);
    }
}
