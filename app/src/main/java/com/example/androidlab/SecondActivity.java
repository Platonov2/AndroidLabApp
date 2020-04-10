package com.example.androidlab;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView textViewFIO, textViewLogin, textViewPassword, textViewPhone;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Intent intent = getIntent();
        sharedPreferences = getSharedPreferences("APP_PREFERENCES", Context.MODE_PRIVATE);

        textViewFIO = findViewById(R.id.textViewFIO);
        textViewLogin = findViewById(R.id.textViewLogin);
        textViewPassword = findViewById(R.id.textViewPassword);
        textViewPhone = findViewById(R.id.textViewPhone);

        String fio = sharedPreferences.getString("FIO", "FIO");
        String login = sharedPreferences.getString("Login", "Login");
        String password = intent.getStringExtra("Password");
        String phone = intent.getStringExtra("Phone");

        textViewFIO.setText(fio);
        textViewLogin.setText(login);
        textViewPassword.setText(password);
        textViewPhone.setText(phone);
    }
}
