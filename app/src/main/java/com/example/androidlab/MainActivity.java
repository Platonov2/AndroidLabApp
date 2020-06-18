package com.example.androidlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView alpha, rotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alpha = findViewById(R.id.alpha);
        rotate = findViewById(R.id.rotate);
    }


    public void onClickButton(View view) {
        Animation animationAlpha = AnimationUtils.loadAnimation(this, R.anim.visibility);
        Animation animationRotate = AnimationUtils.loadAnimation(this, R.anim.rotate);

        alpha.startAnimation(animationAlpha);
        rotate.startAnimation(animationRotate);
    }
}
