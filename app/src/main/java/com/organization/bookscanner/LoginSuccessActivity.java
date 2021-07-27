package com.organization.bookscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginSuccessActivity extends AppCompatActivity {
    Button scanbtn;
    String StringData;
    public static TextView scantext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        scantext=(TextView)findViewById(R.id.scantext);
        scanbtn=(Button) findViewById(R.id.scanbtn);

        scanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),scannerView.class));
            }
        });

        scantext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),WebviewActivity.class);
                StringData = scantext.getText().toString();
                i.putExtra("StringData",StringData);
                startActivity(i);

            }
        });
    }

}