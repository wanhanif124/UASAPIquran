package com.example.uaspemogramanbergerak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.uaspemogramanbergerak.Modelaudio.Audio;
import com.example.uaspemogramanbergerak.Modelaudio.AudioFilesItem;
import com.example.uaspemogramanbergerak.surahmodel.Chapters;
import com.example.uaspemogramanbergerak.surahmodel.ChaptersItem;
import com.example.uaspemogramanbergerak.retrofit.APIservices;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private Mainadapter mainAdapter;

    private List<ChaptersItem> results = new ArrayList<>();
    private List<AudioFilesItem> audio = new ArrayList<>();
    private List<ChaptersItem> listSurah;
    private List<AudioFilesItem> listAudio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
        setUpRecyclerView();
        getDataFromApi();
    }

    private void setUpRecyclerView() {
        mainAdapter = new Mainadapter(results, audio);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mainAdapter);
    }

    private void setUpView() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    private void getDataFromApi() {
        APIservices.endpoint().getSurah().enqueue(new Callback<Chapters>() {
            @Override
            public void onResponse(@NonNull Call<Chapters> call, @NonNull Response<Chapters> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    MainActivity.this.listSurah = response.body().getChapters();
                    getDataFromApiAudio();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Chapters> call, @NonNull Throwable t) {
                Log.d("ErrorMain", t.toString());
            }
        });
    }

    private void getDataFromApiAudio() {
        APIservices.endpoint().getAudio().enqueue(new Callback<Audio>() {
            @Override
            public void onResponse(@NonNull Call<Audio> call, @NonNull Response<Audio> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    MainActivity.this.listAudio = response.body().getAudioFiles();
                    mainAdapter.setData(listSurah, listAudio);
                }
            }

            @Override
            public void onFailure(@NonNull Call<Audio> call, @NonNull Throwable t) {

            }
        });
    }
}


