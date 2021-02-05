package com.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.myapplication.model.UserAccountRequestDto;
import com.myapplication.rest.ApiClient;
import com.myapplication.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private Button btnRegister;
    private EditText inputEmail, inputUsername, inputPassword;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        _initial();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _register();
            }
        });
    }
    
    private void _initial(){
        btnRegister = findViewById(R.id.register_button);
        inputEmail = findViewById(R.id.register_email);
        inputUsername = findViewById(R.id.register_username);
        inputPassword = findViewById(R.id.register_password);
    }

    private void _register(){
        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);
        Call<UserAccountRequestDto> send = api.register(
                inputEmail.getText().toString(),
                inputUsername.getText().toString(),
                inputPassword.getText().toString());
        send.enqueue(new Callback<UserAccountRequestDto>() {
            @Override
            public void onResponse(Call<UserAccountRequestDto> call, Response<UserAccountRequestDto> response) {
                if (response.isSuccessful()){
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<UserAccountRequestDto> call, Throwable t) {
                System.err.println("fail: "+t.getMessage());
            }
        });
    }
}