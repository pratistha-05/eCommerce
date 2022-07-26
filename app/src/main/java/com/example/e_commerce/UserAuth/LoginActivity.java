package com.example.e_commerce.UserAuth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.e_commerce.Homepage.HomePageActivity;
import com.example.e_commerce.R;
import com.example.e_commerce.Retrofit.IPostApi;
import com.example.e_commerce.Retrofit.RetrofitBuilder;
import com.example.e_commerce.Retrofit.model.UserData;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextInputLayout email=findViewById(R.id.emailInput);
        TextInputLayout password=findViewById(R.id.passwordInput);
        Button loginButton=findViewById(R.id.LoginButton);
        Button signIn=findViewById(R.id.signin);

        String emailInput= String.valueOf(email.getEditText().getText());
        String passwordInput= String.valueOf(password.getEditText().getText());
        Retrofit retrofit = RetrofitBuilder.getInstance();
        IPostApi ipostApi = retrofit.create(IPostApi.class);
        loginButton.setOnClickListener(view -> {
                Call<UserData> userDataCall= ipostApi.logIn(emailInput,passwordInput);
                userDataCall.enqueue(new Callback<UserData>() {
                    @Override
                    public void onResponse(Call<UserData> call, Response<UserData> response) {
                        Intent intent=new Intent(LoginActivity.this, HomePageActivity.class);
                        intent.putExtra("name",response.body().getName());
                        intent.putExtra("email",response.body().getEmail());
                        //TODO
                        // Response is null=present the error
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<UserData> call, Throwable t) {

                    }
                });

        });
        signIn.setOnClickListener(view -> {
            Intent intent=new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(intent);
        });

    }
}