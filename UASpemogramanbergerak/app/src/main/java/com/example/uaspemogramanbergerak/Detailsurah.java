package com.example.uaspemogramanbergerak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.uaspemogramanbergerak.ayatmodel.Verses;
import com.example.uaspemogramanbergerak.ayatmodel.VersesItem;
import com.example.uaspemogramanbergerak.terjemahan.Indo;
import com.example.uaspemogramanbergerak.terjemahan.ItemTranslation;
import com.example.uaspemogramanbergerak.retrofit.APIservices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Detailsurah extends AppCompatActivity {

        private RecyclerView recyclerView;
        private AyatAdapter ayatAdapter;
        private final List<VersesItem> versesItemList = new ArrayList<>();
        private final List<ItemTranslation> translationsItemList = new ArrayList<>();
        List<VersesItem> ayat;
        List<ItemTranslation> arti;
        TextView namacomplexsurah, namasimple, jumlahayat, nomorsurah, arab;
        Button audio;
        private MediaPlayer mediaPlayer;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_detailsurah);

            int id = getIntent().getIntExtra("id", 1);
            nomorsurah = findViewById(R.id.nosurah1);
            nomorsurah.setText(String.valueOf(id));

            String nameComplex = getIntent().getStringExtra("nama latin");
            namacomplexsurah = findViewById(R.id.judul);
            namacomplexsurah.setText((nameComplex));

            String namaLatin = getIntent().getStringExtra("nama surah");
            namasimple = findViewById(R.id.namasurah);
            namasimple.setText((namaLatin));

            String namaArab = getIntent().getStringExtra("arab");
            arab = findViewById(R.id.namaarab);
            arab.setText("Nama Arab " + namaArab);

            int jumlahAyat = getIntent().getIntExtra("verses", 1);
            jumlahayat = findViewById(R.id.jumlahayat);
            jumlahayat.setText("Jumlah Ayat " + jumlahAyat);

            mediaPlayer = new MediaPlayer();
            String audioUrl = getIntent().getStringExtra("audio_url");
            audio = findViewById(R.id.button1);
            audio.setOnClickListener(view -> {
                if (mediaPlayer.isPlaying()) {
                    pauseAudio();
                } else {
                    playAudio(audioUrl);
                }
            });

            setUpView();
            setUpRecyclerView();
            System.out.println(id);
            getDatafromApi(id);
        }

        private void pauseAudio() {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            }
        }

        private void playAudio(String audio) {
            try {
                mediaPlayer.reset();
                mediaPlayer.setDataSource(audio);
                mediaPlayer.prepare();
                mediaPlayer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void getDatafromApi(int id) {
            APIservices.endpoint().getIndo(id).enqueue(new Callback<Indo>() {
                @Override
                public void onResponse(@NonNull Call<Indo> call, @NonNull Response<Indo> response) {
                    if (response.isSuccessful()) {
                        assert response.body() != null;
                        Detailsurah.this.arti = response.body().getTranslations();
                        getVersesData(getIntent().getIntExtra("id", 1));
                    }
                }
                @Override
                public void onFailure(@NonNull Call<Indo> call, @NonNull Throwable t) {
                    Log.d("error", t.toString());
                }
            });
        }

        private void getVersesData(int id) {
            APIservices.endpoint().getAyat(id).enqueue(new Callback<Verses>() {
                @Override
                public void onResponse(@NonNull Call<Verses> call, @NonNull Response<Verses> response) {
                    if (response.isSuccessful()) {
                        assert response.body() != null;
                        Detailsurah.this.ayat = response.body().getVerses();
                        ayatAdapter.setData(ayat, arti);
                    }
                }

                @Override
                public void onFailure(@NonNull Call<Verses> call, @NonNull Throwable t) {
                    Log.d("error", t.toString());
                }
            });
        }

        private void setUpRecyclerView() {
            ayatAdapter = new AyatAdapter(versesItemList, translationsItemList);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(ayatAdapter);
        }

        private void setUpView() {
            recyclerView = findViewById(R.id.rvAyat);
        }
    }
