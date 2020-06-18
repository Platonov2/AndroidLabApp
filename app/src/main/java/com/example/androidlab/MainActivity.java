package com.example.androidlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextFIO, editTextLogin, editTextPassword, editTextPhone;
    Button buttonActivity;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonActivity = findViewById(R.id.buttonActivity);
        editTextFIO = findViewById(R.id.editTextFIO);
        editTextLogin = findViewById(R.id.editTextLogin);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextPhone = findViewById(R.id.editTextPhone);
    }


    public void onClickButton(View view) {
        Intent intent = new Intent(this, SecondActivity.class);

        sharedPreferences = getSharedPreferences("APP_PREFERENCES", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Имя и логин сохраняются в память через SharedPreferences
        // *Данные перезаписываются только если в поле введено хоть что-нибудь
        if (!editTextFIO.getText().toString().equals("") && !editTextLogin.getText().toString().equals("")){
            editor.putString("FIO", editTextFIO.getText().toString());
            editor.putString("Login", editTextLogin.getText().toString());

            editor.apply();
        }

        // Пароль и телефон передаются во вторую активити каждый раз через Intent
        intent.putExtra("Password", editTextPassword.getText().toString());
        intent.putExtra("Phone", editTextPhone.getText().toString());

        startActivity(intent);
    }
}
