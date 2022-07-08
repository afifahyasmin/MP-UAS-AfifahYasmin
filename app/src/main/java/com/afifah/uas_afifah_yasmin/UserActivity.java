package com.afifah.uas_afifah_yasmin;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserActivity extends AppCompatActivity {

    TextView tvUser;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        tvUser = findViewById(R.id.tv_user);

        // string name bisa disimpan di 1 constant class atau di global variable
        sharedPreferences = getSharedPreferences("data_shared_preff_kita", MODE_PRIVATE);

        tvUser.setText(sharedPreferences.getString("NAMA", "-"));

    }
}