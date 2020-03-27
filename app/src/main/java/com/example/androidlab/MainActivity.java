package com.example.androidlab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DialogFragment newFragment = new Dialog1();
        newFragment.show(getSupportFragmentManager(), "dialog");

        textView = findViewById(R.id.mainTextView);
        button = findViewById(R.id.changeTextButton);

        View.OnClickListener buttonOnClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Other text");
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
}
