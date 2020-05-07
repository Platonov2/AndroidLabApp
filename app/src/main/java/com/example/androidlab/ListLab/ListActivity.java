package com.example.androidlab.ListLab;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidlab.R;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class ListActivity extends AppCompatActivity {

    ListView listView;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);

        sharedPreferences = getSharedPreferences("APP_PREFERENCES", Context.MODE_PRIVATE);

        listView = findViewById(R.id.listView);

        HashSet<String> posts = (HashSet<String>) sharedPreferences.getStringSet("Posts", null);

        LinkedList<String> listPosts = new LinkedList(posts);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listPosts);

        listView.setAdapter(adapter);
    }

}
