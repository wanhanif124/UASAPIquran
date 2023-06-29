package com.example.uaspemogramanbergerak.retrofit;

import com.example.uaspemogramanbergerak.ayatmodel.Verses;
import com.example.uaspemogramanbergerak.surahmodel.Chapters;
import com.example.uaspemogramanbergerak.terjemahan.Indo;
import com.example.uaspemogramanbergerak.Modelaudio.Audio;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiEndpoint {
    @GET("chapters?language=id")
    Call<Chapters> getSurah();
    @GET("quran/verses/uthmani?")
    Call<Verses> getAyat (@Query("chapter_number") int id);
    @GET("quran/translations/33?")
    Call<Indo> getIndo (@Query("chapter_number") int id);
    @GET("chapter_recitations/33?")
    Call<Audio> getAudio();

}
