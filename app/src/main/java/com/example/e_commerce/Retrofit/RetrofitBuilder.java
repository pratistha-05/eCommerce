package com.example.e_commerce.Retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {
    private static Retrofit instance;

    private RetrofitBuilder() {
    }


    public static Retrofit getInstance() {
        if (instance == null) {
            synchronized (RetrofitBuilder.class) {
                if (instance == null) {
//                    builder pattern changing of parameters
                    instance = new Retrofit.Builder().baseUrl("http://10.20.4.81:8080/")
                            .addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient()).build();

                }
            }
        }
        return instance;

    }
}

