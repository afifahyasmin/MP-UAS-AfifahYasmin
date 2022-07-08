package com.afifah.uas_afifah_yasmin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Asyntask extends AppCompatActivity{
    Button btnRunAsyntask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asyntask);


        btnRunAsyntask = findViewById(R.id.btn_run_asyntask);
        btnRunAsyntask.setOnClickListener(view -> {
            ActivityAsynTask ActivityAsynTask = new ActivityAsynTask();
            ActivityAsynTask.execute("Kirim Parameter");
        });
    }


    private class ActivityAsynTask extends AsyncTask<String, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            Log.i("ActivityAsynTask", "di pre execute");
        }

        @Override
        protected Void doInBackground(String... strings) {
            Log.i("ActivityAsynTask", "di doInBackground");
            Log.i("ActivityAsynTask", "cetak yang dilempar kesini " + strings[0].toString());
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);

            Log.i("ActivityAsynTask", "di post execute");
        }
    }

}
