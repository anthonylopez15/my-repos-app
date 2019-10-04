package com.example.myrepos.services;

import com.example.myrepos.data.ReposDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Service {

    @GET("users/{user}/repos")
    Call<List<ReposDTO>> listRepos(@Path("user") String user);

}
