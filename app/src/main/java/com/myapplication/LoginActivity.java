package com.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.myapplication.model.LoginRequestDto;
import com.myapplication.model.UserAccountRequestDto;
import com.myapplication.rest.ApiClient;
import com.myapplication.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText inputUsername, inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        _initial();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _login();
            }
        });
    }

    private void _initial(){
        btnLogin = findViewById(R.id.login_button);
        inputPassword = findViewById(R.id.login_password);
        inputUsername = findViewById(R.id.login_username);
    }

    private void _login(){
        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);
        Call<LoginRequestDto> send = api.login(
                inputUsername.getText().toString(),
                inputPassword.getText().toString());
        send.enqueue(new Callback<LoginRequestDto>() {
            @Override
            public void onResponse(Call<LoginRequestDto> call, Response<LoginRequestDto> response) {
                System.out.println("berhasil");
                Toast.makeText(LoginActivity.this, "berhasil daftar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<LoginRequestDto> call, Throwable t) {
                System.err.println("fail");
            }
        });
    }
}