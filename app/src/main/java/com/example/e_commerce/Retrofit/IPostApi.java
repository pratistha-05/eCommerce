package com.example.e_commerce.Retrofit;

import android.text.Editable;

import com.example.e_commerce.Retrofit.model.UserData;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;

public interface IPostApi {
    @POST("user/signup") Call<UserData> createNewAcount(@Body UserData userData);





    @POST("user/login")
    Call<UserData> logIn(@Body UserData userData);
    ) ;
}
