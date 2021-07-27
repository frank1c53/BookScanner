package com.organization.bookscanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity:";
    private EditText phoneNo;
    String phone;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneNo=(EditText) findViewById(R.id.phoneno);
        login = (Button)findViewById(R.id.login);




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                phone=phoneNo.getText().toString();
                if(phone.length() == 0 || phone.length() > 10 || phone.length() < 10 ){
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Kindly Enter 10 digit Mobile No");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                } else{
                    Intent i = new Intent(getApplicationContext(),VerifyActivity.class);
                    i.putExtra("phone",phone);
                    startActivity(i);
                    finish();
                }
            }
        });


    }
}