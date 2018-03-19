package com.example.dekstop_martha.imadedwimarthayana_1202150061_studycase4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by DEKSTOP-MARTHA on 3/19/2018.
 */

public class GambarActivity extends AppCompatActivity {

    ImageView gambar; //membuat variabel gambar imageview
    EditText sumber;  //membuat variabel untuk link

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gambar);
        setTitle("AsyncTask"); //set judul pada tampilan

        //memanggil variabel yang ada pada activiti gambar xml
        gambar = (ImageView)findViewById(R.id.Gambar);
        sumber = (EditText)findViewById(R.id.link);
    }
    //method saat button ditekan
    public void search (View view) {
        //loading gambar dari internet ke imageview
        Picasso.with(GambarActivity.this).load(sumber.getText().toString())
                //sebutkan context nya dengan memanggil with dan memberikan context-nya berdasarkan link nya
                .placeholder(R.mipmap.ic_launcher_round)
                //meanmpilkan apabila gambar kita belum ready
                .error(R.mipmap.ic_launcher)
                //menampilkan gambar apabila ada kesalahan
                .into(gambar);//memasukan gambar yang telah ada ke image view


    }
}
