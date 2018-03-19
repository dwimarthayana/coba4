package com.example.dekstop_martha.imadedwimarthayana_1202150061_studycase4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class UtamaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utama);
    }
    public void mahasiswa(View view) {
        //intent aktivitas List mahasiswa//
        Intent i = new Intent(this, ListActivity.class);
        startActivity(i);
    }
    //method saat button ditekan
    public void gambar(View view) {
        //intent berpindah ke aktivitas gambar//
        Intent intent = new Intent(this, GambarActivity.class);
        startActivity(intent);
    }
}
