package com.example.uaspemogramanbergerak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Detailsurah extends AppCompatActivity {

    TextView textViewIDSurah;

    TextView textnama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailsurah);

        String namaSurah = getIntent().getStringExtra("nama surah");
        textnama = findViewById(R.id.tvIDSurah);
        textnama.setText("Nama Surah: " + (namaSurah));

        int id = getIntent().getIntExtra("id", 1);
        textViewIDSurah = findViewById(R.id.tvIDSurah3);
        textViewIDSurah.setText("Surah ke: " + (id));

        String namalatin = getIntent().getStringExtra("nama latin");
        textnama = findViewById(R.id.tvIDSurah2);
        textnama.setText("Nama latin: " + (namalatin));

        String arab = getIntent().getStringExtra("arab");
        textnama = findViewById(R.id.tvIDSurah4);
        textnama.setText(arab);
    }
}
