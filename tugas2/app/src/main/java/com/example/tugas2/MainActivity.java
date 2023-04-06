package com.example.tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText ap,ak;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ap = findViewById(R.id.Angka_Pertama);
        ak = findViewById(R.id.Angka_Kedua);
        btn = findViewById(R.id.tombol1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ang1 = Integer.parseInt(ap.getText().toString());
                int ang2 = Integer.parseInt(ak.getText().toString());

                int rom = ang1 +ang2;

                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("key", rom);
                startActivity(intent);
            }
        });
    }
}