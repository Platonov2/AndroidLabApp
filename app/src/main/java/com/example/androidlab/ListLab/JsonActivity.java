package com.example.androidlab.ListLab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidlab.R;

import java.util.HashSet;
import java.util.LinkedHashSet;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressLint("Registered")
public class JsonActivity extends AppCompatActivity {

    EditText idEditText;
    TextView userIdTextView, titleTextView, bodyTextView;
    Button findPostButton, toListActivityButton;

    SharedPreferences sharedPreferences;

    // HashSet используется для сохранения постов в памяти устройства.
    HashSet<String> hashSet = new HashSet<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_activity);

        idEditText = findViewById(R.id.idEditText);
        userIdTextView = findViewById(R.id.userIdTextView);
        titleTextView = findViewById(R.id.titleTextView);
        bodyTextView = findViewById(R.id.bodyTextView);
        findPostButton = findViewById(R.id.findPostButton);
        toListActivityButton = findViewById(R.id.toListActivityButton);

        // Получение объекта json и его вывод на экран.
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

                                String postId = Integer.toString(post.getId());
                                String postTitle = post.getTitle();
                                String postBody = post.getBody();

                                // Добавление поста в HashSet.
                                String postInfo = postId + " \n \n " + postTitle + " \n \n " + postBody;
                                hashSet.add(postInfo);

                                // Сохранение постов впамяти.
                                sharedPreferences = getSharedPreferences("APP_PREFERENCES", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();

                                editor.putStringSet("Posts", hashSet);

                                editor.apply();

                                userIdTextView.setText(postId);
                                titleTextView.setText(postTitle);
                                bodyTextView.setText(postBody);
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

    public void toListActivityButtonClick(View view) {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }
}
