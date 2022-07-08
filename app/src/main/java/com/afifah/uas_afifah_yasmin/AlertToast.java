package com.afifah.uas_afifah_yasmin;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import cn.pedant.SweetAlert.SweetAlertDialog;


public class AlertToast extends AppCompatActivity {

    Button buttonAlert;
    Button buttonWarning;
    Button buttonToast;
    Button buttonCustome;
    Button buttonLoading;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerttoast);

        buttonAlert = findViewById(R.id.alertButton);
        buttonWarning = findViewById(R.id.confirmationButton);
        buttonToast = findViewById(R.id.toastButton);
        buttonCustome = findViewById(R.id.customeButton);
        buttonLoading = findViewById(R.id.loadingButton);

        // 1. Alert messag
        buttonAlert.setOnClickListener(v -> new SweetAlertDialog(this)
                .setTitleText("Hi! This is Afifah")
                .show());

        // 2. Confirmation message
        buttonWarning.setOnClickListener(v -> new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Are you sure? Go to Isekai")
                .setContentText("You will not be able to return to the world!")
                .setConfirmText("Yes!")
                .setConfirmClickListener(SweetAlertDialog::dismissWithAnimation)
                .setCancelButton("Cancel", SweetAlertDialog::dismissWithAnimation)
                .show());

        // 3. Toast message
        buttonToast.setOnClickListener(v -> {
            // Displaying simple Toast message
            Toast.makeText(this, "Hey! This is Toast", Toast.LENGTH_LONG)
                    .show();
        });

        // 4. Custome message
        buttonCustome.setOnClickListener(v -> {
            SweetAlertDialog pDialog = new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE);
            pDialog.setTitleText("Woops!");
            pDialog.setContentText("Here's an Android Logo.");
            pDialog.setCustomImage(R.drawable.android_developer_logo_170920110556);
            pDialog.show();
        });

        // 5. Loading message
        buttonLoading.setOnClickListener(v -> {
            SweetAlertDialog pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
            pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
            pDialog.setTitleText("Go to Isekai...");
            pDialog.setCancelable(true);
            pDialog.show();
        });
    }
}
