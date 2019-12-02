package com.example.retrofit_02_github_users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://api.github.com/";

    @GET("users")
    Call<List<User>> getUsers();

}
