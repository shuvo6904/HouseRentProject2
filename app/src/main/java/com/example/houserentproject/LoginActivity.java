package com.example.houserentproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login Form");
    }

    public void buttonRegister(View view) {

        startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
        finish();
    }

    public void buttonLogin(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }
}