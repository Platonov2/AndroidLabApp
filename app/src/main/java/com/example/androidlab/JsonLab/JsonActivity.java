package com.example.androidlab.JsonLab;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidlab.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressLint("Registered")
public class JsonActivity extends AppCompatActivity {

    EditText idEditText;
    TextView userIdTextView, titleTextView, bodyTextView;
    Button findPostButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_activity);

        idEditText = findViewById(R.id.idEditText);
        userIdTextView = findViewById(R.id.userIdTextView);
        titleTextView = findViewById(R.id.titleTextView);
        bodyTextView = findViewById(R.id.bodyTextView);
        findPostButton = findViewById(R.id.findPostButton);

        View.OnClickListener buttonOnClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(idEditText.getText().toString());

                NetworkService.getInstance()
                        .getJSONApi()
                        .getPostWithID(id)
                        .enqueue(new Callback<Post>() {
                            @Override
                            public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
                                Post post = response.body();

                                userIdTextView.setText(Integer.toString(post.getId()));
                                titleTextView.setText(post.getTitle());
                                bodyTextView.setText(post.getBody());
                            }

                            @Override
                            public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {

                                userIdTextView.setText(R.string.errorMessage);
                                t.printStackTrace();
                            }
                        });
            }
        };
        findPostButton.setOnClickListener(buttonOnClick);
    }
}
