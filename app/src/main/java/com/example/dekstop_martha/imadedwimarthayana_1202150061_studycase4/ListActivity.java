package com.example.dekstop_martha.imadedwimarthayana_1202150061_studycase4;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by DEKSTOP-MARTHA on 3/19/2018.
 */

public class ListActivity extends AppCompatActivity {
    ListView listMahasiswa; //mendeklarasikan variabel yang dibutuhkan

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setTitle("AsyncTask"); //set title pada tampilan layar
        listMahasiswa = (ListView) findViewById(R.id.listMh); //memanggil atribut yang ada di layout
    }
    //saat button ditekan
    public void mulai(View view) {
        new getData(listMahasiswa).execute(); //proses asynctask dimulai
    }
    //subclass assynctask
    class getData extends AsyncTask<String, Integer, String> {
        ListView listMahasiswa; //membuat atribut listview
        ArrayAdapter adapter; //membuat adapter
        ArrayList<String> listNama; //membuat array dengan nama listnama
        ProgressDialog dialog; //membuat progress dialog

        //constructor saat asynctask diinisialisasi
        public getData(ListView listMahasiswa) {
            this.listMahasiswa = listMahasiswa;
            dialog = new ProgressDialog(ListActivity.this);
            listNama = new ArrayList<>();
        }

        //method ketika proses asynctask belum dimulai
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //menampilkan proses dialog
            dialog.setTitle("Loading Data");
            dialog.setIndeterminate(true);
            dialog.setProgress(0);
            dialog.setMax(100);
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setCancelable(true);
            dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialog.dismiss();
                    getData.this.cancel(true);
                }
            });

            dialog.show();
        }

        // proses asynctask dijalankan
        @Override
        protected String doInBackground(String... strings) {
            adapter = new ArrayAdapter<>(ListActivity.this, android.R.layout.simple_list_item_1, listNama);
            //membuat adapter

            //menyimpan array pada sebuah variabel
            String[] mhs = getResources().getStringArray(R.array.namaMhs);
            //perulangan untuk menyimpan array
            for (int a = 0; a < mhs.length; a++) {
                final long persen = 100 * a / mhs.length; //angka pembagian persen
                final String nama = mhs[a];
                try {
                    Runnable change = new Runnable() {
                        @Override
                        public void run() {
                            dialog.setMessage((int) persen+"% - Adding "+nama);
                            //add persen dan nama yang akan ditampilkan
                        }
                    };
                    runOnUiThread(change);
                    Thread.sleep(300);
                    listNama.add(mhs[a]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        //sesudah asynctask sudah dijalankan
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            listMahasiswa.setAdapter(adapter);
            dialog.dismiss();
        }
    }
}
