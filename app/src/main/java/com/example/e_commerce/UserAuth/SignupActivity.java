package com.example.e_commerce.UserAuth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_commerce.Homepage.HomePageActivity;
import com.example.e_commerce.R;
import com.example.e_commerce.Retrofit.IPostApi;
import com.example.e_commerce.Retrofit.RetrofitBuilder;
import com.example.e_commerce.Retrofit.model.UserData;
import com.google.android.material.textfield.TextInputLayout;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        EditText name = findViewById(R.id.signIn_name);
        EditText email = findViewById(R.id.signIn_email);
        EditText password = findViewById(R.id.signIn_passwordInput);
        EditText confirmPassword = findViewById(R.id.signIn_confirmPasswordInput);
        EditText contact_number = findViewById(R.id.signIn_number);

        TextView warn = findViewById(R.id.warning);
        Button signIn = findViewById(R.id.signin);
        Button login = findViewById(R.id.login_text);


        Retrofit retrofit = RetrofitBuilder.getInstance();
        IPostApi ipostApi = retrofit.create(IPostApi.class);

        signIn.setOnClickListener(view -> {
            String nameInput = name.getText().toString().trim();
            String emailInput;
            emailInput = email.getText().toString().trim();
            String passwordInput = password.getText().toString().trim();
            String confirmPasswordInput = confirmPassword.getText().toString().trim();
            String contactNumber = contact_number.getText().toString().trim();


            if (!passwordInput.equals(confirmPasswordInput))
                warn.setTextColor(Color.parseColor("#F60202"));


            if (TextUtils.isEmpty(nameInput)) {
                name.setError("Please Enter Name");
                name.requestFocus();
                return;
            }
            if (TextUtils.isEmpty(emailInput)) {
                email.setError("Please Enter Email");
                email.requestFocus();
                return;
            }
            if (TextUtils.isEmpty(passwordInput)) {
                password.setError("Please Enter Password");
                password.requestFocus();
                return;

            }
            /*if (TextUtils.isEmpty(contactNumber)) {
                contact_number.setError("Please Enter Password");
                contact_number.requestFocus();
                return;

            }

             */
           // UserData userdata = new UserData(nameInput, emailInput, passwordInput, contactNumber);
            UserData userData = new UserData();
            userData.setName(nameInput);
            userData.setEmail(emailInput);
            userData.setPassword(passwordInput);
            userData.setPhoneNo(contactNumber);
            Call<UserData> userDataCall = ipostApi.createNewAcount(userData);
            //Log.e("values", String.valueOf(ipostApi.createNewAcount(userdata)));
            //Log.e("values", nameInput+" "+emailInput);
            userDataCall.enqueue(new Callback<UserData>() {
                @Override
                public void onResponse(Call<UserData> call, Response<UserData> response) {
                    Log.e("response",response.body().toString());
                    Intent intent = new Intent(SignupActivity.this, HomePageActivity.class);
                    startActivity(intent);
                }

                @Override
                public void onFailure(Call<UserData> call, Throwable t) {
                    Log.e("response",t.getMessage());
                }
            });

                    /*login.setOnClickListener(view -> {
                        Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                        startActivity(intent);
                    });


                     */


        });
    }
}
