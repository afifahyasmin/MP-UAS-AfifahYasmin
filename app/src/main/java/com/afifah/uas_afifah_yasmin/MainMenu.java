package com.afifah.uas_afifah_yasmin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {
    Button btnAlertToast, btnAsyntask, btnCamera, btnLocalDB, btnMaps, btnSharePreff, btnSMS, btnTabLayout, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAlertToast = findViewById(R.id.btnAlertToast);
        btnAsyntask = findViewById(R.id.btnAsyntask);
        btnCamera = findViewById(R.id.btnCamera);
        btnLocalDB = findViewById(R.id.btnLocalDB);
        btnMaps = findViewById(R.id.btnMaps);
        btnSharePreff = findViewById(R.id.btnSharePreff);
        btnSMS = findViewById(R.id.btnSMS);
        btnTabLayout = findViewById(R.id.btnTabLayout);
        btnExit = findViewById(R.id.btnExit);


        btnAlertToast.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AlertToast.class);
                startActivity(intent);
                finish();

            }
        });

        btnAsyntask.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, Asyntask.class);
                finish();
                startActivity(intent);
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, Camera.class);
                finish();
                startActivity(intent);
            }
        });

        btnLocalDB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, LocalDB.class);
                finish();
                startActivity(intent);
            }
        });

        btnMaps.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, Maps.class);
                finish();
                startActivity(intent);
            }
        });

        btnSharePreff.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, SharePreff.class);
                finish();
                startActivity(intent);
            }
        });

        btnSMS.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, SMS.class);
                finish();
                startActivity(intent);
            }
        });

        btnTabLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, TabViewActivity.class);
                finish();
                startActivity(intent);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                moveTaskToBack(true);
            }
        });
    }
}