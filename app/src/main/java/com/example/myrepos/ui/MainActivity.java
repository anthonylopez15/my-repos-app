package com.example.myrepos.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.myrepos.R;
import com.example.myrepos.data.ReposDTO;
import com.example.myrepos.services.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Service services = retrofit.create(Service.class);
        Call<List<ReposDTO>> call = services.listRepos("octocat");

        call.enqueue(new Callback<List<ReposDTO>>() {
            @Override
            public void onResponse(Call<List<ReposDTO>> call, Response<List<ReposDTO>> response) {
                if (response.isSuccessful()) {
                    List<ReposDTO> responseRepos = response.body();
                    for (ReposDTO user : responseRepos) {
                        Log.i(TAG, user.getmName());
                    }
                } else {
                    Log.d(TAG, "An error has happened " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<ReposDTO>> call, Throwable t) {
                Log.e(TAG, "failed to connect to server");
            }
        });

    }
}
