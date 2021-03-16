package com.example.houserentproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void tvAlreadyRegistered(View view) {

        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }
}