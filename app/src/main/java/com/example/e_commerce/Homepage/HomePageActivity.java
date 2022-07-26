package com.example.e_commerce.Homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.e_commerce.R;
import com.example.e_commerce.Retrofit.IPostApi;
import com.example.e_commerce.Retrofit.RetrofitBuilder;

import retrofit2.Retrofit;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Retrofit retrofit = RetrofitBuilder.getInstance();
        IPostApi ipostApi = retrofit.create(IPostApi.class);
    }
}