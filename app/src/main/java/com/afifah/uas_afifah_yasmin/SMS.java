package com.afifah.uas_afifah_yasmin;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SMS extends AppCompatActivity  {
    private EditText phoneNumber;
    private EditText smsBody;
    private Button smsManagerBtn;
    private Button smsSendToBtn;
    private Button smsViewBtn;

    @Override    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        smsBody = (EditText) findViewById(R.id.smsBody);
        smsSendToBtn = (Button) findViewById(R.id.smsSIntent);

        smsSendToBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSmsBodySIntent();

            }
        });
    }

    public void sendSmsBodySIntent() {
        Uri uri = Uri.parse("smsto:" + phoneNumber.getText().toString());
        Intent smsSIntent = new Intent(Intent.ACTION_SENDTO,uri);
        smsSIntent.putExtra("sms_body", smsBody.getText().toString());
        try {
            startActivity(smsSIntent);
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "Sms gagal",
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();

        }
    }
}
