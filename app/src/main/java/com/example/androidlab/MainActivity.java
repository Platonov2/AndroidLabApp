package com.example.androidlab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView mainTextView, dialogTextView1, dialogTextView2, dialogTextView3, dialogTextView4;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DialogFragment newFragment = new Dialog1();
        newFragment.show(getSupportFragmentManager(), "dialog");

        mainTextView = findViewById(R.id.mainTextView);
        button = findViewById(R.id.changeTextButton);

        View.OnClickListener buttonOnClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTextView.setText("Other text");
            }
        };

        button.setOnClickListener(buttonOnClick);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case (R.id.account): {
                Toast toast = Toast.makeText(getApplicationContext(), "account", Toast.LENGTH_SHORT);
                toast.show();
                break;
            }
            case (R.id.android): {
                Toast toast = Toast.makeText(getApplicationContext(), "android", Toast.LENGTH_SHORT);
                toast.show();
                break;
            }
            case (R.id.bank): {
                Toast toast = Toast.makeText(getApplicationContext(), "balance", Toast.LENGTH_SHORT);
                toast.show();
                break;
            }
            case (R.id.bug): {
                Toast toast = Toast.makeText(getApplicationContext(), "bug", Toast.LENGTH_SHORT);
                toast.show();
                break;
            }
            case (R.id.build): {
                Toast toast = Toast.makeText(getApplicationContext(), "forward", Toast.LENGTH_SHORT);
                toast.show();
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    public void onDialogApply(){
        dialogTextView1 = findViewById(R.id.dialogTextView1);
        dialogTextView2 = findViewById(R.id.dialogTextView2);
        dialogTextView3 = findViewById(R.id.dialogTextView3);
        dialogTextView4 = findViewById(R.id.dialogTextView4);

        dialogTextView1.setVisibility(View.VISIBLE);
        dialogTextView1.setTextColor(Color.parseColor("#121910"));

        dialogTextView2.setVisibility(View.VISIBLE);
        dialogTextView2.setTextColor(Color.parseColor("#2271b3"));

        dialogTextView3.setVisibility(View.VISIBLE);
        dialogTextView3.setTextColor(Color.parseColor("#6c3b2a"));

        dialogTextView4.setVisibility(View.VISIBLE);
        dialogTextView4.setTextColor(Color.parseColor("#000000"));
    }

    public void onDialogDismiss(){
    }
}
