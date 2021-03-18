package com.example.houserentproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    EditText regFullName, regPhnNum, regEmail, regPass, regConPass;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regFullName = findViewById(R.id.regFullNameId);
        regPhnNum = findViewById(R.id.regPhnNumId);
        regEmail = findViewById(R.id.regEmailId);
        regPass = findViewById(R.id.regPassId);
        regConPass = findViewById(R.id.regConPassId);
        fAuth = FirebaseAuth.getInstance();
    }

    public void tvAlreadyRegistered(View view) {

        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }

    public void register(View view) {

        String strFullName = regFullName.getText().toString();
        String strPhnNum = regPhnNum.getText().toString();
        String strEmail = regEmail.getText().toString();
        String strPass = regPass.getText().toString();
        String strConPass = regConPass.getText().toString();

        if (strFullName.isEmpty()){
            regFullName.setError("Full Name is Required");
            return;
        }

        if (strPhnNum.isEmpty()){
            regPhnNum.setError("Phone Number is Required");
            return;
        }

        if (strEmail.isEmpty()){
            regEmail.setError("Email is Required");
            return;
        }

        if (strPass.isEmpty()){
            regPass.setError("Password is Required");
            return;
        }

        if (strConPass.isEmpty()){
            regConPass.setError("Confirm Password is Required");
            return;
        }

        if (!strPass.equals(strConPass)){
            regConPass.setError("Password Don't Match");
            return;
        }

        Toast.makeText(RegisterActivity.this, "Data Validated", Toast.LENGTH_SHORT).show();

        fAuth.createUserWithEmailAndPassword(strEmail, strPass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {

                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                finish();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}