package com.example.androidlab.ListLab;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JSONPlaceHolderApi {
    @GET("/posts/{id}")
    Call<Post> getPostWithID(@Path("id") int id);
}
