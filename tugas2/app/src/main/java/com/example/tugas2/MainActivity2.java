package com.example.tugas2;

import static com.example.tugas2.R.id.hasil;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView getdata;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getdata = findViewById(R.id.hasil);

        Intent intent = getIntent();

        int data = intent.getIntExtra("key", 0);

        getdata.setText(Integer.toString(data));
    }
}
